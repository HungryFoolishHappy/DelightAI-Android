package global.delight.delightaiandroiddemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.painterResource

@Composable
fun ChatScreen(modifier: Modifier = Modifier, messages: SnapshotStateList<Message?>, onMessagesAdd: (Message) -> Unit, scrollState: ScrollState,) {
    // Chat UI Area
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        for (message in messages) {
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                if (message != null) {
                    if (message.isUser) {
                        Spacer(modifier = Modifier.weight(1f))
                    } else {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(45.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.delight_chatbot_10),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(45.dp)
                            )
                        }
                    }
                }
                if (message != null) {
                    Text(
                        message.text,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        color = if (message.isUser) Color.White else Color.Black,
                        modifier = Modifier
                            .padding(
                                start = if (message.isUser) 30.dp else 10.dp,
                                end = if (message.isUser) 0.dp else 30.dp,
                            )
                            .background(
                                color = if (message.isUser) Color.Blue else Color.LightGray,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = if (message.isUser) Color.Blue else Color.LightGray,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(10.dp)
                    )
                }
            }
        }

    }
}