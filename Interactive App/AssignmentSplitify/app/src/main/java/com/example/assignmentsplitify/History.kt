package com.example.assignmentsplitify

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentsplitify.Data.ExpHistory
import com.example.assignmentsplitify.Data.ExpHistoryInfo
import com.example.assignmentsplitify.ui.theme.AssignmentSplitifyTheme

class History : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentSplitifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExpenseHistory(ExpHistoryInfo)
                }
            }
        }
    }
}

@Composable
fun HistoryItem(
    ExpHistoryInformation: ExpHistory,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_small)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth(),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Column(modifier =Modifier.
                    padding(start = dimensionResource(id = R.dimen.padding_small),
                            bottom = dimensionResource(id = R.dimen.padding_small),
                            top= dimensionResource(id = R.dimen.padding_medium)
                    )
            ) {
                Text(
                    modifier =Modifier.padding(start = 200.dp),
                    text = stringResource(id = ExpHistoryInformation.date),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Row {
                    Text(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        text = stringResource(id = R.string.item),
                        color = Color.Black // For example, specify color explicitly
                    )
                    Text(
                        text = stringResource(id = ExpHistoryInformation.item),
                        fontWeight = FontWeight.Light,
                        fontSize = 30.sp,
                        color = Color.Black // Specify color explicitly
                    )
                }
                Row {
                    Text(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        text = stringResource(id = R.string.price),
                        color = Color.Black // Specify color explicitly
                    )
                    Text(
                        text = ExpHistoryInformation.price.toString(), // Convert Int to String
                        fontWeight = FontWeight.Light,
                        fontSize = 30.sp,
                        color = Color.Black // Specify color explicitly
                    )
                }
                Row {
                    Text(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        text = stringResource(id = R.string.paid_by),
                        color = Color.Black // Specify color explicitly
                    )
                    Text(
                        text = stringResource(id = ExpHistoryInformation.paidBy),
                        fontWeight = FontWeight.Light,
                        fontSize = 30.sp,
                        color = Color.Black // Specify color explicitly
                    )
                }
            }
        }
    }
}

@Composable
fun ExpenseHistory(expHistoryList: List<ExpHistory>) {
    Scaffold(
        topBar = {
            HistoryBar()
        },
        content = { padding ->
            LazyColumn(contentPadding = padding) {
                this.items(expHistoryList) { expHistory ->
                    HistoryItem(expHistory, Modifier.padding(16.dp))
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryBar() {
    CenterAlignedTopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
                    text = stringResource(id = R.string.expHistory),
                    fontSize = 32.sp,
                    fontWeight= FontWeight.Bold
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AssignmentSplitifyTheme {
        ExpenseHistory(ExpHistoryInfo)
    }
}