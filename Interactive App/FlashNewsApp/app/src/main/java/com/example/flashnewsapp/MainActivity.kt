package com.example.flashnewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashnewsapp.ui.theme.FlashNewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashNewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsApp()
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
fun NewsApp(){
    var counter by remember { mutableStateOf(1) }
    if(counter == 4) counter = 1
    if(counter == -1) counter = 1
    if (counter==0) counter=1
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White) ){
        when(counter){
            1->{
                NewsAppWork(img = R.drawable.screenshot_2024_02_18_164102, imgdesc = R.string.badweathedate, shortdec = R.string.badweather, news =R.string.badweatherFullNews , date =R.string.badweathedate)
            }
            2->{
                NewsAppWork(img = R.drawable.budget, imgdesc = R.string.budgetimgDesc, shortdec = R.string.budgetsmalldesc, news = R.string.newsBudget, date = R.string.budgetDate)
            }
            3->{
                NewsAppWork(img = R.drawable.screenshot_2024_02_18_161909, imgdesc = R.string.airforceSmallDesc, shortdec = R.string.airforceSmallDesc, news = R.string.airForceNews, date = R.string.airforceDate)
            }
        }
        addButtons(
            onDecrement = { counter--},
            onIncrement = { counter++}
        )
    }
}

@Composable
fun NewsAppWork(
    img:Int,
    imgdesc:Int,
    shortdec:Int,
    news:Int,
    date:Int,
){
    var palat by remember { mutableStateOf(false) }
    Column() {
        ImageOrText(img,
            imgdesc,
            news,
            palat,
            onClickImg ={
                palat= !palat
            }
        )
        addText(text1 = shortdec , text2 = date)
    }
}

@Composable
fun ImageOrText(
    imge: Int,
    imgDesc: Int,
    desc: Int,
    palat: Boolean,
    onClickImg: () -> Unit
) {
    if (palat) {
        LazyColumn(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .size(450.dp)
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .clickable { onClickImg() }
                        .fillMaxSize()
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(12.dp))
                ) {
                    Text(
                        text = stringResource(id = desc),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    } else {
        val shadowModifier = Modifier.shadow(elevation = 8.dp, shape = RoundedCornerShape(12.dp))
        Column {
            Text(
                text = stringResource(id = R.string.tapToKnow),
                modifier = shadowModifier
            )
            Image(
                painter = painterResource(id = imge),
                contentDescription = stringResource(id = imgDesc),
                modifier = Modifier
                    .size(450.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(0.dp, 0.dp, 0.dp, 20.dp)
                    .clickable { onClickImg() }
                    .then(shadowModifier)
                    .background(MaterialTheme.colorScheme.background) // Add this line
            )
        }
    }
}





@Composable
fun addText(
    text1: Int,
    text2: Int
) {
    Box(
        modifier = Modifier
            .background(Color.LightGray.copy(alpha = 0.5f))
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier) {
            Text(
                text = stringResource(id = text1),
                fontSize = 23.sp,
                fontFamily = FontFamily.Serif,
            )
            Text(
                text = stringResource(id = text2),
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
            )
        }
    }
}



@Composable
fun addButtons(onIncrement: ()->Unit, onDecrement:() ->Unit){
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(onClick = { onDecrement() },
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .shadow(elevation = 16.8.dp, shape = RoundedCornerShape(12.dp)) // Add shadow to Button
        ) {
            Text(text = stringResource(id = R.string.prev))
        }
        Button(onClick = { onIncrement() },
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .shadow(elevation = 16.8.dp, shape = RoundedCornerShape(10.dp)) // Add shadow to Button
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlashNewsAppTheme {
        NewsApp()
    }
}