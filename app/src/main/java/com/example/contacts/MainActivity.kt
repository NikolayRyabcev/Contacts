package com.example.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contacts.ui.theme.ContactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contact = null
        setContent {
            ContactsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    contact?.let { ContactDetails(it) }
                }
            }
        }
    }
}

@Composable
fun ContactDetails(contact: Contact, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(30.dp, 30.dp),
            alignment = Alignment.Center,
            painter = if (contact.imageRes != null) {
                painterResource(id = contact.imageRes)
            } else painterResource(
                id = R.drawable.baseline_circle_24
            ),
            contentDescription = null
        )
        Row {
            //Имя
            Text(
                text = contact.name,
                modifier = modifier
            )
            //Отчество
            Text(
                text = contact.surname ?: "",
                modifier = modifier
            )
        }
        //Фамилия
        Text(
            text = contact.familyName,
            modifier = modifier
        )
        //Телефон
        Text(
            text = contact.phone,
            modifier = modifier
        )
        //Адрес
        Text(
            text = contact.address,
            modifier = modifier
        )//е-мэйл
        Text(
            text = contact.email ?: "",
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    ContactsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = {
                ContactDetails(
                    Contact(
                        "Евгений",
                        "Андреевич",
                        "Лукашин",
                        null,
                        true,
                        "Телефон: +7 495 495 95 95",
                        "г. Москва, 3-я улица Стриотелей, д.25, кв.12",
                        "E-mail: E-lukashin@practicum.ru"
                    )
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    ContactsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = {
                ContactDetails(
                    Contact(
                        "Василий",
                        null,
                        "Кузякин",
                        R.drawable._12x512,
                        true,
                        "Телефон: ---",
                        "Ивановская область, дер. Крутово, д.4",
                        null
                    )
                )
            }
        )
    }
}
