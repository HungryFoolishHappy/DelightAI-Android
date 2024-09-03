package global.delight.delightai

import global.delight.delightai.DelightAIClientBuilder
import global.delight.delightai.repository.DelightAIRepository
import global.delight.delightai.model.DelightPollingResponse
import global.delight.delightai.model.DelightResponse

class DelightAIClient internal constructor(builder: DelightAIClientBuilder) {
    suspend fun sendChat(text: String, webhook_id: String, user_id: String, username: String, message_id: String): DelightResponse? {
        val delightAI = DelightAIRepository()
        return delightAI.sendChat(text, webhook_id, user_id, username, message_id)
    }

    suspend fun polling(webhook_id: String): DelightPollingResponse? {
        val delightAI = DelightAIRepository()
        return delightAI.polling(webhook_id)
    }
}