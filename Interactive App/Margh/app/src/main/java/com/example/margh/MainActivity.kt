package com.example.margh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.margh.Data.Page
import com.example.margh.Data.pages
import com.example.margh.ui.theme.MarghTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarghTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MarghApp()
                }
            }
        }
    }
}






@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPages(pages: List<Page>) {
    val pagerState = rememberPagerState(pageCount = pages.size)

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val currentPage = pages[page]
        PageItem(page = currentPage)
    }
}

@Composable
fun MarghApp() {
    VerticalPages(pages = pages)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarghTheme {
        MarghApp()
    }
}