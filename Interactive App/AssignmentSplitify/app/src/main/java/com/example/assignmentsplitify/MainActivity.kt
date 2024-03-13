package com.example.assignmentsplitify

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentsplitify.Data.Person
import com.example.assignmentsplitify.Data.keyValuePairs
import com.example.assignmentsplitify.ui.theme.AssignmentSplitifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentSplitifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplitifyApp()
                }
            }
        }
    }
}


@Composable
fun SplitifyApp() {
    Scaffold(
        topBar = {
            SplitifyAppBar()
        },
        content = { padding ->
            LazyColumn(contentPadding = padding) {
                item {
                    MonthlyEnpBox(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_Large)))
                }
            }
        }
    )
    floatingButton(onClick = {})
}

@Composable
fun floatingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            SmallFloatingActionButton(
                onClick = { onClick() },
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Filled.Add, "Small floating action button.")
            }
        }
}




@Composable
fun SpentBy() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Column {
            Text(
                text = stringResource(id = R.string.spent_by),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.padding_Large))
            )
            // Displaying key-value pairs in the second Text field
            KeyValuesList()
        }
    }
}

@Composable
fun KeyValuesList() {
    Text(
        text = buildKeyValueString(keyValuePairs),
        modifier = Modifier.padding(top = 8.dp,start = dimensionResource(id = R.dimen.padding_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    )
}

// Helper function to build a string from key-value pairs with each pair on a new line
@Composable
private fun buildKeyValueString(data: List<Person>): String {
    val stringBuilder = StringBuilder()
    for (person in data) {
        stringBuilder.append("${stringResource(id = person.key)}:   ₹${person.value} \n")
        stringBuilder.append("\n")
    }
    return stringBuilder.toString()
}

@Composable
fun MonthlyEnpBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.monthly_exp),
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            BoxExpenses("100")
            SpentBy();
            val context = LocalContext.current
            Button(
                onClick = {
                    val intent = Intent(context, History::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)
            ) {
                Text(
                    text = stringResource(id = R.string.show_exp),
                    fontSize = 21.sp
                )
            }
        }
    }
}



@Composable
fun BoxExpenses(monthExp:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(170.dp)
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.background)
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(12.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(7.dp),
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    text = stringResource(id = R.string.this_month_exp)
                )
                Text(modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 35.sp,
                    text = monthExp
                )
            }
        }
        Box(
            modifier = Modifier
                .size(170.dp)
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.background)
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(12.dp))
                .clickable {
                    // Handle click for the second box
                }
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                text = stringResource(id = R.string.past_price)
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplitifyAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.screenshot_2024_03_12_183145),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size)),
                    painter = painterResource(R.drawable._6330f95e5f907dd65fec5f6cf6a1faf),
                    contentDescription = null
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AssignmentSplitifyTheme {
        SplitifyApp()
    }
}