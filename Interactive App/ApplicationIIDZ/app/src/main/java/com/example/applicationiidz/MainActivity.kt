package com.example.applicationiidz


import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applicationiidz.ui.theme.ApplicationIIDZTheme
import java.util.Calendar
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationIIDZTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Registration(onSubmit = { name, date, email ->
                        openNewActivityWithData(name, date, email)
                    })
                }
            }
        }
    }
    fun openNewActivityWithData(name: String, date: String, email: String) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("NAME", name)
        intent.putExtra("DATE", date)
        intent.putExtra("EMAIL", email)
        startActivity(intent)
    }
}


@Composable
fun Registration(onSubmit: (name: String, date: String, email: String)-> Unit){
    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(text1 = R.string.welcome, text2 = R.string.enterDetails)
        EnterName(onNameChanged = { newName -> name = newName })
        EnterBirthdate(onDateChanged = { newDate -> date = newDate })
        EnteremailId(onEmailChanged = { newEmail -> email = newEmail })
        Button(onClick = {
            // Call the lambda when the button is clicked
            onSubmit(name, date, email)
        }) {
            Text(text = "Submit")
        }
    }
}



@Composable
fun Greeting(
    text1 :Int,
    text2 :Int,
){
    Box(modifier = Modifier.padding(0.dp,25.dp,50.dp,0.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = text1),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.Black,
            )
            Text(
                text = stringResource(id = text2),
                fontSize = 20.sp,
                color = Color.Black,
            )
        }
    }
}



@Composable
fun EnterName(onNameChanged: (String) -> Unit){
    var name by remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(top=30.dp, bottom = 0.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.Name),
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 30.dp, bottom = 7.dp)
            )
            TextField(
                value = name,
                onValueChange = { newValue ->
                    name = newValue
                    onNameChanged(newValue)
                },
                singleLine = true,
                label = {
                    Text(text = stringResource(id = R.string.enterName))
                }
            )
        }
    }
}

@Composable
fun EnterBirthdate(onDateChanged: (String) -> Unit) {
    Box(modifier = Modifier.padding(25.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(
                text = stringResource(id = R.string.enterDate),
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 15.dp)
            )
            showDatePicker(onDateChanged)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun showDatePicker(onDateChanged: (String) -> Unit) {
    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val context = LocalContext.current

    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
            onDateChanged(date.value)
        }, year, month, day
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selected Date: ${date.value}")
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            datePickerDialog.show()
        }) {
            Text(text = "Open Date Picker")
        }
    }
}


@Composable
fun EnteremailId(onEmailChanged: (String) -> Unit) {
    var email by remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(25.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.enterEmail),
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 15.dp)
            )
            TextField(value = email,
                onValueChange = { newValue ->
                    email = newValue
                    onEmailChanged(newValue)
                },
                singleLine = true,
                label = {
                    Text(text = stringResource(id = R.string.enteremailId))
                })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApplicationIIDZTheme {
        Registration(onSubmit = { _, _, _ -> /* empty lambda or TODO */ })
    }
}