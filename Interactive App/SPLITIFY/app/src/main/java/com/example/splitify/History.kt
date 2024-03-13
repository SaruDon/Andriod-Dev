import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splitify.Data.ExpHistory
import com.example.splitify.Data.ExpHistoryInfo
import com.example.splitify.R
import com.example.splitify.ui.theme.SPLITIFYTheme
import androidx.compose.ui.graphics.Color

class History : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SPLITIFYTheme {
                // A surface container using the 'background' color from the theme
                ExpenseHistory(ExpHistoryInfo = ExpHistoryInfo)
            }
        }
    }
}

@Composable
fun HistoryItem(
    ExpHistoryInformation: ExpHistory,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column {
            Row {
                Text(
                    modifier = Modifier.padding(10.dp),
                    fontSize = 21.sp,
                    text = stringResource(id = R.string.item),
                    color = Color.Black // For example, specify color explicitly
                )
                Text(
                    text = stringResource(id = ExpHistoryInformation.item),
                    color = Color.Black // Specify color explicitly
                )
            }
            Row {
                Text(
                    text = stringResource(id = R.string.price),
                    color = Color.Black // Specify color explicitly
                )
                Text(
                    text = ExpHistoryInformation.price.toString(), // Convert Int to String
                    color = Color.Black // Specify color explicitly
                )
            }
            Row {
                Text(
                    text = stringResource(id = R.string.paid_by),
                    color = Color.Black // Specify color explicitly
                )
                Text(
                    text = stringResource(id = ExpHistoryInformation.paidBy),
                    color = Color.Black // Specify color explicitly
                )
            }
        }
    }
}

@Composable
fun ExpenseHistory(ExpHistoryInfo: List<ExpHistory>) {
    LazyColumn {
        items(ExpHistoryInfo) { expHistory ->
            HistoryItem(
                ExpHistoryInformation = expHistory,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryPreview() {
    SPLITIFYTheme {
        ExpenseHistory(ExpHistoryInfo)
    }
}
