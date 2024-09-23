package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday sonia!",
                        from = "From Emma"
                    )

                }
            }
        }
    }
}




@Preview(showBackground = true, name = "hbd")
@Composable
fun BirthdayCardPreview() {
    TestTheme {
        GreetingImage(
            message = "Happy Birthday sonia!",
            from = "From Emma"
        )
    }
}


@Composable
fun GreetingText(message: String,from:String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement= Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 90.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            textAlign = TextAlign.End

        )
    }
}
@Composable
fun GreetingImage(message: String, from: String,modifier:Modifier=Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier){
        Image(
            painter = image,
            contentDescription = null
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}


@Preview(showBackground = true, name = "ARTICLE")
@Composable
fun articlePreview() {
    TestTheme {

        GreetingCartes(texte = "")
    }

}

@Composable
fun GreetingArticle(sms: String,  modif:Modifier=Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modif.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "Jetpack Compose tutorial",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.articl_content2),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)

        )
        Text(
            text = stringResource(R.string.article_content),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)

        )

    }
}
@Composable
fun GreetingTaches(texte: String,  modif:Modifier=Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(modif.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "All tasks completed",



            modifier = Modifier.padding(top=24.dp, bottom = 6.dp),

        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)

        )
    }
}


@Composable
fun GreetingCartes(texte: String,  modif:Modifier=Modifier) {
    val image = painterResource(R.drawable.ic_launcher_foreground)
    val im = painterResource(R.drawable.call_24dp_e8eaed)
    Column(modif.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            painter = im,
            contentDescription = null

        )
        Text(
            text = "NAHOUSSI Sonia",



            modifier = Modifier.padding(top=24.dp, bottom = 4.dp),

            )
        Text(
            text = "Android connecte",
            fontSize = 10.sp,


        )
        Text(
            text = " 657660099",
            fontSize = 14.sp,
            modifier = Modifier.padding(top=100.dp)

            )
        Text(
            text = " sonifanga@gmail.com",
            fontSize = 14.sp,


        )
    }
}