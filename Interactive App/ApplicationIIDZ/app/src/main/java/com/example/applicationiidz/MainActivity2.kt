package com.example.applicationiidz


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applicationiidz.ui.theme.ApplicationIIDZTheme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationIIDZTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Retrieve data from Intent
                    val name = intent.getStringExtra("NAME") ?: ""
                    val date = intent.getStringExtra("DATE") ?: ""
                    val email = intent.getStringExtra("EMAIL") ?: ""

                    // Display data using Greeting2 composable
                    DataShow(name, date, email)
                }
            }
        }
    }
}

@Composable
fun DataShow(name: String, date: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Greeting()
        DataTable(listOf(DataRow("Name", name), DataRow("Date", date), DataRow("Email", email)))
    }
}
data class DataRow(val label: String, val value: String)
@Composable
fun DataTable(dataRows: List<DataRow>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .border(1.dp, Color.Black)
            .padding(8.dp)
    ) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Name",
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray) // Set background color
                    .padding(8.dp),
                color = Color.White // Set text color
            )
            Spacer(modifier = Modifier.width(1.dp).background(Color.Black)) // Vertical line
            Text(
                text = "Birthdate",
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray) // Set background color
                    .padding(8.dp),
                color = Color.White // Set text color
            )
            Spacer(modifier = Modifier.width(1.dp).background(Color.Black)) // Vertical line
            Text(
                text = "Email",
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray) // Set background color
                    .padding(8.dp),
                color = Color.White // Set text color
            )
        }

        // Horizontal line
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black))

        // Data rows
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = dataRows[0].value,
                modifier = Modifier.weight(1f),
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(1.dp).background(Color.Black)) // Vertical line
            Text(
                text = dataRows[1].value,
                modifier = Modifier.weight(1f),
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(1.dp).background(Color.Black)) // Vertical line
            Text(
                text = dataRows[2].value,
                modifier = Modifier.weight(1f),
                color = Color.Black
            )
        }
    }
}


@Composable
fun Greeting() {
    Box(modifier = Modifier.padding(0.dp, 25.dp, 50.dp, 0.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.RegSus),
                fontWeight = FontWeight.Bold,
                fontSize = 29.sp,
                color = Color.Black,
            )
            Text(
                text = stringResource(id = R.string.deitalsReg),
                fontSize = 20.sp,
                color = Color.Black,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ApplicationIIDZTheme {
        DataShow("", "", "")
    }
}
