package global.delight.delightaiandroiddemo

import java.util.UUID

data class Message(
    val isUser: Boolean,
    val text: String,
    val id: String = UUID.randomUUID().toString()
)