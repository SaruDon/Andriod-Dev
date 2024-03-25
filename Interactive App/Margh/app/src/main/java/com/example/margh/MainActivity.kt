import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.margh.R
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

@Composable
fun MarghApp() {
    Box(){
        Column {
            TopBar();
        }
    }
}

@Composable
fun TopBar() {
    Column {
        Text(
            text = stringResource(id = R.string.Afternoon_are_for_inspiration)
        )
        Row {
            Button(
                onClick = {},
                content = {
                    Text(
                        text = stringResource(id = R.string.random)
                    )
                }
            )
            SearchBar()
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().height(32.dp),
        value = "", // Set the value of the text field here
        onValueChange = { /* TODO: Handle value change */ },
        label = { Text(text = "Search") }, // Label for the text field
        singleLine = true, // Restrict input to a single line
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarghTheme {
        MarghApp()
    }
}
