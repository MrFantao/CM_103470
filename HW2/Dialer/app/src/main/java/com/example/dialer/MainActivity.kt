package com.example.dialer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dialer.ui.theme.DialerTheme

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialerTheme {
                DialerApp()
            }

        }
    }
}

@Composable
fun DialerScreenAndKeyboard(modifier: Modifier = Modifier) {

    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),

        verticalArrangement = Arrangement.Bottom

        ) {
        Text(
            text = "$phoneNumber",
            modifier = Modifier
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {

            Column(
                //verticalArrangement = Arrangement.Bottom,
            ) {
                Button(onClick = { phoneNumber += "1" }) {
                    Text(stringResource(R.string.number1))
                }
                Button(onClick = { phoneNumber += "4" }) {
                    Text(stringResource(R.string.number4))
                }
                Button(onClick = { phoneNumber += "9" }) {
                    Text(stringResource(R.string.number9))
                }
                Button(onClick = { phoneNumber += "#" }) {
                    Text(stringResource(R.string.numberCardinal))
                }
            }

            Column(
                //verticalArrangement = Arrangement.Bottom
            ) {
                Button(onClick = { phoneNumber += "2" }) {
                    Text(stringResource(R.string.number2))
                }
                Button(onClick = { phoneNumber += "5" }) {
                    Text(stringResource(R.string.number5))
                }
                Button(onClick = { phoneNumber += "8" }) {
                    Text(stringResource(R.string.number8))
                }
                Button(onClick = { phoneNumber += "0" }) {
                    Text(stringResource(R.string.number0))
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(stringResource(R.string.phone))
                }
            }

            Column(
                //verticalArrangement = Arrangement.Bottom
            ) {
                Button(onClick = { phoneNumber += "3" }) {
                    Text(stringResource(R.string.number3))
                }
                Button(onClick = { phoneNumber += "6" }) {
                    Text(stringResource(R.string.number6))
                }
                Button(onClick = { phoneNumber += "9" }) {
                    Text(stringResource(R.string.number9))
                }
                Button(onClick = { phoneNumber = removeLastCharacter(phoneNumber) }) {
                    Text(stringResource(R.string.numberBack))
                }
            }
        }
    }
}

@Preview
@Composable
fun DialerApp() {
    DialerScreenAndKeyboard()
}

//Function to remove last character of string
fun removeLastCharacter(input: String): String {
    if (input.isNotEmpty()) {
        return input.dropLast(1)
    }
    return input // Return the original string if it's empty
}