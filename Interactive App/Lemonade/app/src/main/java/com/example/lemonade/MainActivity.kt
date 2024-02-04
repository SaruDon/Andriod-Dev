package com.example.lemonade

import android.content.Context
import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer


import androidx.compose.foundation.layout.fillMaxHeight


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    GreetingPreview()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MakeLemonade(){
    var currentState by remember { mutableStateOf(1) } // Tracking the number of clicks
    var noOfClicks by remember { mutableStateOf(0) } // Tracking the number of squeezes

    when(currentState){
        1-> {
            ImageandText(
                textResouceId = R.string.lemon_tree,
                imageResourceId = R.drawable.lemon_tree,
                contentDesc = R.string.LtreeImg,
                onImageClick = {
                    currentState = 2
                    noOfClicks = (2..4).random()  //Ass
                }
            )
        }
        2-> ImageandText(
            textResouceId = R.string.keep_tapping_to_squeez,
            imageResourceId = R.drawable.lemon_squeeze,
            contentDesc = R.string.LemonImg,
            onImageClick = {
                noOfClicks--
                if (noOfClicks==0){
                    currentState=3
                }
            })
        3-> ImageandText(
            textResouceId = R.string.tap_to_drink,
            imageResourceId = R.drawable.lemon_drink,
            contentDesc = R.string.Glass_of_lemondateImg,
            onImageClick = {
                currentState =4;
            })
        4-> ImageandText(
            textResouceId = R.string.restart,
            imageResourceId = R.drawable.lemon_restart,
            contentDesc = R.string.EmptyImg,
            onImageClick = {
                currentState =1;
            })
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
//        //Greeting("Android")
//        LemonadeApp()
//        //tree(currentStep = 1)
        MakeLemonade()
    }
}


@Composable
fun ImageandText(
    textResouceId: Int,
    imageResourceId: Int,
    contentDesc: Int,
    onImageClick: () -> Unit
) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = contentDesc.toString()
                )
                Text(
                    text = stringResource(id = textResouceId),
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}


