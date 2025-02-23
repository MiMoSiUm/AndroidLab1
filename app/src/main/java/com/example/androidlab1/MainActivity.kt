package com.example.androidlab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlab1.ui.theme.AndroidLab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidLab1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardCenter(
                        name = stringResource(R.string.name_text),
                        post = stringResource(R.string.post_text),
                        phone = stringResource(R.string.phone_text),
                        link = stringResource(R.string.link_text),
                        mail = stringResource(R.string.mail_text),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    CardCenter(
//                        name = stringResource(R.string.name_text),
//                        post = stringResource(R.string.post_text),
//                        phone = stringResource(R.string.phone_text),
//                        link = stringResource(R.string.link_text),
//                        mail = stringResource(R.string.mail_text)
//                    )
//                }
            }
        }
    }
}

@Composable
fun CardBottom(phone: String, link: String, mail: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(bottom = 20.dp)
    ) {
        Text(
            text = phone
        )
        Text(
            text = link
        )
        Text(
            text = mail
        )
    }
}

@Composable
fun CardCenter(name: String, post: String, phone: String, link: String, mail: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
//        verticalArrangement = Arrangement.SpaceAround,
//        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.weight(1f)
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = name,
                fontSize = 40.sp
            )
            Text(
                text = post
            )
        }
        CardBottom(
            phone = phone,
            link = link,
            mail = mail
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    AndroidLab1Theme {
        CardCenter(
            name = stringResource(R.string.name_text),
            post = stringResource(R.string.post_text),
            phone = stringResource(R.string.phone_text),
            link = stringResource(R.string.link_text),
            mail = stringResource(R.string.mail_text)
        )
    }
}