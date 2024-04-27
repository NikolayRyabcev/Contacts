package com.example.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.contacts.ui.theme.ContactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactDetails()
                }
            }
        }
    }
}

@Composable
fun ContactDetails(/*item:Contact*/){
    Box{
        Image(painter=painterResource(id=R.drawable.baseline_circle_24),
            contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContactsTheme {
        ContactDetails()
    }
}