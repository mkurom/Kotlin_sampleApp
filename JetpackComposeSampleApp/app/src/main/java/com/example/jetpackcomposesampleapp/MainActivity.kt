package com.example.jetpackcomposesampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposesampleapp.ui.theme.JetpackComposeSampleAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //JetpackComposeSampleAppTheme {
                //Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                //}
            //}
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}


data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//// Previewアノテーションをつけると、プレビューが表示される
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetpackComposeSampleAppTheme {
//        Greeting("Android")
//    }
//}