package com.example.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contacts.ui.theme.ContactsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contact = null
        setContent {
            ContactsTheme {
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
    val fio = contact.name.substring(0, 1) + (contact.surname?.substring(0, 1) ?: "")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        if (contact.imageRes == null) RoundedPicture(s = fio) else Image(
            modifier = Modifier.size(width = 100.dp, height = 100.dp),
            painter = painterResource(id = R.drawable._12x512),
            contentDescription = null
        )
        Row {
            //Имя
            Text(
                text = contact.name + " ",
                modifier = modifier,
                style = MaterialTheme.typography.headlineSmall
            )
            //Отчество
            Text(
                text = contact.surname ?: "",
                modifier = modifier,
                style = MaterialTheme.typography.headlineSmall
            )
        }
        //Фамилия
        Row {
            Text(
                text = contact.familyName,
                modifier = modifier,
                style = MaterialTheme.typography.headlineMedium
            )
            if (contact.isFavorite) Image(
                painter = painterResource(id = android.R.drawable.star_big_on),
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )
        }
        //Телефон
        Row(
            modifier = Modifier.padding(
                top = 20.dp,
                bottom = 8.dp,
            )
        ) {
            Text(
                text = "Телефон: ",
                modifier = Modifier.weight(0.5f),
                textAlign = TextAlign.Right,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = contact.phone,
                modifier = Modifier.weight(0.5f)

            )
        }
        //Адрес
        Row(
            modifier = Modifier.padding(
                top = 20.dp,
                bottom = 8.dp,
            )
        ) {
            Text(
                text = "Адрес: ",
                modifier = Modifier.weight(0.5f),
                textAlign = TextAlign.Right,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = contact.address,
                modifier = Modifier.weight(0.5f)

            )
        }
        //е-мэйл
        if (contact.email != null) Row(
            modifier = Modifier.padding(
                top = 20.dp,
                bottom = 8.dp,
            )
        ) {
            Text(
                text = "E-mail: ",
                modifier = Modifier.weight(0.5f),
                textAlign = TextAlign.Right
            )
            Text(
                text = contact.email,
                modifier = Modifier.weight(0.5f)

            )
        }
    }
}

@Composable
fun RoundedPicture(s: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(50.dp, 50.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(24.dp)
                .background(Color.Gray, shape = CircleShape)
        ) {
            Text(
                text = s,
                color = Color.White
            )
        }
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
                        "+7 495 495 95 95",
                        "г. Москва, 3-я улица Стриотелей, д.25, кв.12",
                        "E-lukashin@practicum.ru"
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
                        false,
                        "-",
                        "Ивановская область, дер. Крутово, д.4",
                        null
                    )
                )
            }
        )
    }
}
