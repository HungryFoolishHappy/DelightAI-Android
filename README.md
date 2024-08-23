# DelightAI-Android

## Introduction
Delight is an "AI for All" platform that lets anyone create their own AI agent, chatbot, or copilot without coding or technical skills. It simplifies the AI creation process to improve life, work, and play.

## Demo
To try the demo app, simply clone this project.
[delight-android-demo.webm](https://github.com/user-attachments/assets/cfc6228e-e7be-469f-a722-e3ceceedaefd)

## Installation 💻
In your `build.gradle.kts` implement your dependencies:

```kotlin
dependencies {
    ...
    implementation("global.delight:delightai:0.0.1")
    ...
}
```

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


