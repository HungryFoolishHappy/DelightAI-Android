package global.delight.delightaiandroiddemo

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

@Composable
fun MainActivityScreen(context: Context) {
    var webhook_id by rememberSaveable { mutableStateOf("a4b404d4-5f9a-4617-a5a4-8ea338352eb4") }
    var username by rememberSaveable { mutableStateOf("Wi-android-9937-491d-aefd-02e6b89ff0aa") }
    var user_id by rememberSaveable { mutableStateOf("Wi-android-9937-491d-aefd-02e6b89ff0aa") }

    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.delight_logo_foreground),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text("Delight Demo", fontSize = 36.sp, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = webhook_id,
            onValueChange = { webhook_id = it },
            prefix = { Text("Webhook ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.padding(2.dp))
        TextField(
            value = username,
            onValueChange = { username = it },
            prefix = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.padding(2.dp))
        TextField(
            value = user_id,
            onValueChange = { user_id = it },
            prefix = { Text("User ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    val intent = Intent(context, ChatActivity::class.java)
                    intent.putExtra("webhook_id", webhook_id)
                    intent.putExtra("user_id", user_id)
                    intent.putExtra("username", username)
                    context.startActivity(intent)
                }
            ) {
                Text(
                    text = "Save",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

    }
}