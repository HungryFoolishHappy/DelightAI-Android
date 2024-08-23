package global.delight.delightai.service

import global.delight.delightai.model.DelightPollingResponse
import global.delight.delightai.model.DelightRequest
import global.delight.delightai.model.DelightResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path

internal interface DelightAIService {
    /**
     * Send a Chat request to the Delight API
     * @param webhook_id the webhook id of the agent
     */
    @Headers("Content-Type: application/json")
    @POST("webhook/webwidget/{webhook_id}/")
    suspend fun sendChat(
        @Body delightRequest: DelightRequest, @Path("webhook_id") webhook_id: String
    ): Response<DelightResponse>

    /**
     * Send a polling request to the Delight API
     * @param polling_url the url from sendChat response
     */
    @GET("{polling_url}")
    suspend fun polling(
        @Path("polling_url", encoded = true) polling_url: String
    ): Response<DelightPollingResponse>
}