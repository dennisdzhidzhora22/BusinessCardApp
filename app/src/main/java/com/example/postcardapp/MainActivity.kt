package com.example.postcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postcardapp.ui.theme.PostcardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostcardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    BusinessCardImage(fullName = "Dennis Dzhidzhora", title = "Computer Science Student", email = "dennis.dzhidzhora01@login.cuny.edu")
                }
            }
        }
    }
}

@Composable
fun BusinessCardText(fullName: String, title: String, email: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Text(
            text = fullName,
            fontSize = 50.sp,
            lineHeight = 54.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = title,
            fontSize = 30.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = email,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun BusinessCardImage(fullName: String, title: String, email: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.logo)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            alignment = Alignment.BottomCenter,
            modifier = Modifier.size(350.dp).align(Alignment.CenterHorizontally)
        )
        BusinessCardText(
            fullName = fullName,
            title = title,
            email = email,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    PostcardAppTheme {
        BusinessCardImage("Dennis Dzhidzhora", title = "Computer Science Student", email = "dennis.dzhidzhora01@login.cuny.edu")
    }
}