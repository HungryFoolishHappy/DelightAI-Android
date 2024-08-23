# DelightAI-Android

## Introduction
This demo app uses [DelightAI-Android](https://github.com/HungryFoolishHappy/DelightAI-Android). Delight is an "AI for All" platform that lets anyone create their own AI agent, chatbot, or copilot without coding or technical skills. It simplifies the AI creation process to improve life, work, and play.

## Demo
To try the demo app, simply clone this project.
[Delight Demo Video.webm](https://github.com/user-attachments/assets/2383c679-7b67-4dfd-b2eb-1a01bf05c979)

## Installation New Project

## Installation 💻

## Usage Example
Import the module in your project:

```kotlin
import com.delightai.api.ChatBuilder
import com.delightai.api.PollingBuilder
```

```koltin
GlobalScope.launch {
    val build = ChatBuilder().build() 
    val pollingBuild = PollingBuilder().build()
    val response = build.send(
                        text = text, // text to DelightAI
                        webhook_id = webhook_id, // a demo webhook Id, you can use it for testing
                        user_id = user_id, // user id that send to DelightAI
                        username = username, // username that send to DelightAI
                        message_id = message_id) // message id 
    withContext(Dispatchers.IO) {
        val pollingResponse = pollingBuild.polling(webhook_id = response.poll)
        if (pollingResponse?.completed == true) {
            // do something
        }
    }
}
```


