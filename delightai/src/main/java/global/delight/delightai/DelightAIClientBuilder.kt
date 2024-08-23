package global.delight.delightai

import global.delight.delightai.DelightAIClient

abstract class DelightAIClientBuilder() {
}

class ChatBuilder: DelightAIClientBuilder() {
    fun build(): DelightAIClient = DelightAIClient(this)
}

class PollingBuilder: DelightAIClientBuilder() {
    fun build(): DelightAIClient = DelightAIClient(this)
}