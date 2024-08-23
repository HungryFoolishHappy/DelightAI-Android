package global.delight.delightai.repository

import global.delight.delightai.model.DelightPollingResponse
import global.delight.delightai.model.DelightRequest
import global.delight.delightai.model.DelightRequestMessage
import global.delight.delightai.model.DelightRequestMessageFrom
import global.delight.delightai.model.DelightResponse
import global.delight.delightai.service.DelightAIService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

internal class DelightAIRepository {
    private var apiService: DelightAIService? = null

    suspend fun sendChat(text: String, webhook_id: String, user_id: String, username: String, message_id: String): DelightResponse? {

        val delightRequest = DelightRequest(message = DelightRequestMessage(
            message_id = message_id,
            date = System.currentTimeMillis(),
            text = text,
            from = DelightRequestMessageFrom(id = user_id, username = username, language_code = "en"))
        )

        getApiService()?.let {
            val response = it.sendChat(delightRequest, webhook_id)

            if (!response.isSuccessful()) {
                return handleError(response, DelightResponse::class.java)
            }

            return response.body()
        }

        return null
    }

    suspend fun polling(webhook_id: String): DelightPollingResponse? {
        getApiService()?.let {
            val decodedUrl = URLDecoder.decode(webhook_id, StandardCharsets.UTF_8.toString())
            println(decodedUrl)
            val response = it.polling(decodedUrl)

            if (!response.isSuccessful()) {
                return handleError(response, DelightPollingResponse::class.java)
            }
            return response.body()
        }
        return null
    }

    private fun <T> handleError(response: Response<T>, classOfT: Class<T>): T? {
        return try {
            val errorString = response.errorBody()?.string()
            Gson().fromJson(errorString, classOfT)
        } catch (e: Exception) {
            println("unable to parse error body, $e")
            null
        }
    }

    private fun getApiService(): DelightAIService? {
        if (apiService == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://qa.delight.global")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            apiService = retrofit.create(DelightAIService::class.java)
        }

        return apiService
    }
}