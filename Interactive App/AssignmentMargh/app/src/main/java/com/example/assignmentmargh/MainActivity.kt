package com.example.assignmentmargh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentmargh.Data.Page
import com.example.assignmentmargh.ui.theme.AssignmentMarghTheme
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import com.example.assignmentmargh.Data.pages
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentMarghTheme {
                // A surface container using the 'background' color from the theme
                MarghApp()
            }
        }
    }
}

@Composable
fun MarghApp() {
    Column(Modifier.fillMaxSize()) {
        TopBar(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
        ImageDisplay(pages = pages)
    }
}
@Composable
fun ImageDisplay(pages: List<Page>) {
    val currentPage = remember { mutableStateOf(0) }

    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()) {
            IconButton(
                onClick = {
                    if (currentPage.value > 0) {
                        currentPage.value--
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("<", fontSize = 24.sp)
            }

            IconButton(
                onClick = {
                    if (currentPage.value < pages.size - 1) {
                        currentPage.value++
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(">", fontSize = 24.sp)
            }
        }

        ImageResource(imageRes = pages[currentPage.value].image)
    }
}


@Composable
fun ImageResource(imageRes: Int) {
    val painter = rememberImagePainter(imageRes)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
        contentScale = ContentScale.FillWidth
    )
}


@Composable
fun TopBar(modifier: Modifier =Modifier) {
    Column {
        Text(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            text = stringResource(id = R.string.Afternoon_are_for_inspiration),
            fontSize = 30.sp,
            fontWeight = FontWeight.Black
        )
        Row (
            Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
        ){
            Button(
                onClick = {},
                content = {
                    Text(
                        text = stringResource(id = R.string.random)
                    )
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            SearchBar()
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp),
        value = "",
        onValueChange = { /* TODO: Handle value change */ },
        label = { Text(text = "Search") },
        singleLine = true,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AssignmentMarghTheme {
        MarghApp()
    }
}
