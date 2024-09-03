# DelightAI-Android

## Introduction
Delight is an "AI for All" platform that lets you create your own AI agent or chatbot with no code or low code. 

Using this SDK, you can embed your agent into your Android app. Creating an agent on Delight (https://delight.global) takes only a few minutes, and 
so is embedding it into your app.

## Demo
To try the demo app, simply clone this project. The demo comes with a pre-built, sample agent.

https://github.com/user-attachments/assets/fb541c65-2024-41a4-9092-e20887f1d647

## Installation 💻
In your `build.gradle.kts` implement your dependencies:

```kotlin
dependencies {
    ...
    implementation("global.delight:delightai:0.0.2")
    ...
}
```

## Usage Example
Import the module in your project:

```kotlin
import global.delight.delightai.ChatBuilder
import global.delight.delightai.PollingBuilder
```

Initialize ChatBuilder and PollingBuilder. Call the send(...) function to send information to your agent. Then, handle the agent response which will arrive by polling.

```koltin
GlobalScope.launch {
    val build = ChatBuilder().build() 
    val pollingBuild = PollingBuilder().build()
    val response = build.send(
                        text = text, // text to DelightAI, usually user’s message or prompt
                        webhook_id = webhook_id, // our demo webhook id, or your agent’s actual webhook id from https://delight.global
                        user_id = user_id,
                        username = username,
                        message_id = message_id)
    withContext(Dispatchers.IO) {
        val pollingResponse = pollingBuild.polling(webhook_id = response.poll)
        if (pollingResponse?.completed == true) {
            // do something
        }
    }
}
```


