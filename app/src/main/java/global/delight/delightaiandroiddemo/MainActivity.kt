package global.delight.delightaiandroiddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import global.delight.delightaiandroiddemo.ui.theme.DelightaiandroiddemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            DelightaiandroiddemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormComponent(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FormComponent(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    MainActivityScreen(context)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DelightaiandroiddemoTheme {
        FormComponent("")
    }
}