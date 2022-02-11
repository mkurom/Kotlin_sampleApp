package com.example.jetpackcomposesampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
            JetpackComposeSampleAppTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }
}


data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",

            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = msg.body,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {

    // ui.themeのTheme.ktファイルのJetpackComposeSampleAppTheme関数
    JetpackComposeSampleAppTheme {
        MessageCard(
            msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
        )
    }
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