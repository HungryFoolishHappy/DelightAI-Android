package global.delight.delightai.model

data class DelightPollingResponse (
    var uuid: String,
    var completed: Boolean,
    var text: String?,
    var new_tokens: String?,
    var error: DelightError? = null
)