package com.example.businesscard

import android.os.Bundle
import android.widget.NumberPicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun carInfoBox(){
    Box (
        Modifier
            .size(450.dp)
            .padding(16.dp),
            contentAlignment = Alignment.BottomCenter

    ){
        val image = painterResource(R.drawable.android_logo)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Color(0xFFCDDCA3))
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .background(color = Color(0xFF05472A)).size(150.dp),
            )
            Text(
                text = stringResource(R.string.sarvesh_k),
                fontSize = 30.sp,
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFF000000)
            )
            Text(
                text = stringResource(R.string.andriod_devloper),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000)
            )
        }
    }
}

@Composable
fun cardContact() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(16.dp)
    ) {
        val phone = painterResource(R.drawable.pngtreephone_icon_5105607)
        val share = painterResource(R.drawable.pngegg)
        val email = painterResource(R.drawable.email)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = phone,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .background(color = Color(0xFFCDDCA3)),
                tint= Color(0xFFCDDCA3)
            )
            Text(
                text = stringResource(R.string.sarveshNo),
                modifier = Modifier.padding(start = 8.dp),
                color = Color(0xFF000000)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = share,
                contentDescription = null,
                modifier = Modifier.size(24.dp).background(color = Color(0xFFCDDCA3)),
                tint= Color(0xFFCDDCA3)
            )
            Text(
                text = stringResource(R.string.sarveshappdev),
                modifier = Modifier.padding(start = 8.dp),
                color = Color(0xFF000000)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = email,
                contentDescription = null,
                modifier = Modifier.size(24.dp).background(color = Color(0xFFCDDCA3)),
                tint= Color(0xFFCDDCA3)
            )
            Text(
                text = stringResource(R.string.sarveshkhamkar321_gmail_com),
                modifier = Modifier.padding(start = 8.dp),
                color = Color(0xFF000000)
            )
        }
    }
}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme() {
        Column(modifier = Modifier
            .background(color = Color(0xFFCDDCA3)),) {
            carInfoBox()
            Spacer(modifier = Modifier.height(16.dp))
            cardContact()
        }
    }
}