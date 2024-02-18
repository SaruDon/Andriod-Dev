package com.example.artwork

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artwork.ui.theme.ArtWorkTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtWorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWrok()
                }
            }
        }
    }
}

@Composable
fun ArtWrok() {
    var counter by remember { mutableStateOf(1) }
    var palat by remember { mutableStateOf(false) }
    if(counter == 4) counter = 1
    if(counter == -1) counter = 1
    if (counter==0) counter=1

//    var artwork:Int
//    var artworkDesc:Int
//    var artworkName:Int
//    var artworkYear:Int
    when(counter){
        1->{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (palat==false){
                    Box{
                        ImageDispay(imgResourceId = R.drawable.screenshot_2024_02_17_193357, conetentDescId = R.string.mona,onClickImg={palat=true})
                    }
                }else{
                   Box{
                       addTextOrImg(text = R.string.monoInfo, onClickImg = {palat=false}, modifier = Modifier.padding(20.dp))
                   }
                }
                Box {
                    addText(text1 = R.string.monArtist, text2 = R.string.monYear)
                }
                Box {
                    addButton(
                        onIncrement = { counter++
                            palat=false},
                        onDecrement = { counter--
                            palat=false}
                    )
                }

            }
        }
        2->{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (palat==false){
                    Box{ImageDispay(imgResourceId = R.drawable.star, conetentDescId = R.string.starArt,onClickImg={palat=true})}

                }else{
                    Box{addTextOrImg(text = R.string.theStarryNight, onClickImg = {palat=false}, modifier = Modifier.padding(20.dp))}
                }
                Box {
                    addText(text1 = R.string.starArt, text2 = R.string.starYear)
                }
                Box {
                    addButton(
                        onIncrement = {
                            counter++
                            palat = false
                        },
                        onDecrement = {
                            counter--
                            palat = false
                        }
                    )
                }
            }
        }
        3->{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (palat==false){
                    ImageDispay(imgResourceId = R.drawable.women, conetentDescId = R.string.theGirl,onClickImg={palat=true})
                }else{
                    addTextOrImg(text = R.string.theGirlInfo, onClickImg = {palat=false}, modifier = Modifier.padding(20.dp))
                }
                addText(text1 = R.string.theGirlArtist, text2 = R.string.gilrYear)
                addButton(
                    onIncrement = { counter++
                                  palat=false},
                    onDecrement = { counter--
                                    palat=false}
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtWorkTheme {
        ArtWrok()
    }
}

@Composable
fun addTextOrImg(
    text: Int,
    onClickImg:()->Unit,
    modifier: Modifier
){
    LazyColumn(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .size(400.dp).padding(0.dp,0.dp,0.dp,20.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .clickable { onClickImg() }
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = text),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ImageDispay(
    imgResourceId: Int,
    conetentDescId: Int,
    onClickImg:()->Unit,
){
    Image(painter = painterResource(id = imgResourceId),
            contentDescription = stringResource(id = conetentDescId),
            modifier = Modifier
                .size(400.dp)
                .clip(RoundedCornerShape(12.dp))
                .padding(0.dp, 0.dp, 0.dp, 50.dp)
                .clickable { onClickImg() }
    )
}

@Composable
fun addText(
    text1: Int,
    text2: Int
){
    Box(modifier = Modifier
        .background(Color.LightGray.copy(alpha = 0.5f))
        .padding(5.dp)
    ){
        Column(modifier = Modifier) {
            Text(text = stringResource(id = text1),
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
            )
            Text(text = stringResource(id = text2),
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
            )
        }
    }
}




@Composable
fun addButton(onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Row(
        modifier = Modifier.padding(20.dp).fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = { onDecrement() },
            modifier = Modifier.padding(15.dp,0.dp)
        ) {
            Text(
                text = stringResource(id = R.string.prev)
            )
        }
        Button(
            onClick = { onIncrement() },
        ) {
            Text(
                text = stringResource(id = R.string.next)
            )
        }
    }
}