package global.delight.delightai.model

data class DelightRequestMessageFrom(
    val id: String,
    val username: String,
    val language_code: String,
)

data class DelightRequestMessage(
    val message_id: String,
    val from: DelightRequestMessageFrom,
    val date: Long,
    var text: String,
)

data class DelightRequest(
    var message: DelightRequestMessage,
)