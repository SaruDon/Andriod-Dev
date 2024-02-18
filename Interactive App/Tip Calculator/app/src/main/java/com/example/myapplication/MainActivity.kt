package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle.Companion.Normal
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.w3c.dom.Text
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TipCalculator()
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
fun TipCalculator(){
    var amountInput by remember { mutableStateOf("") }
    var tipPercenatageInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercenatage = tipPercenatageInput.toDoubleOrNull() ?: 0.0
    val tip = calCulateTip(amount,tipPercenatage,roundUp)
    Box(
        contentAlignment = Alignment.Center
    ){
       Column(
           modifier = Modifier
               .padding(40.dp)
               .verticalScroll(rememberScrollState()),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ){
            Text(
                text = stringResource(R.string.Calculate_tip),
                modifier = Modifier.padding(15.dp)
            )
            EditNumberField(
                leadingIcon = R.drawable._5473,
                value = amountInput,
                onValueChange = { amountInput = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth(),
                label = R.string.BillAmt,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
           EditNumberField(
               leadingIcon = R.drawable._6832,
               value = tipPercenatageInput,
               onValueChange = {tipPercenatageInput =it},
               modifier = Modifier
                   .padding(bottom = 32.dp)
                   .fillMaxWidth(),
               label = R.string.Tip_pere,
               keyboardOptions = KeyboardOptions.Default.copy(
                   keyboardType = KeyboardType.Number,
                   imeAction = ImeAction.Done
               )
               )
           RoundUpTheTipRow(
               roundUp = roundUp,
               onRoundUpChanged = { roundUp = it },
               modifier = Modifier.padding(bottom = 32.dp)
           )
           Text(
               text = stringResource(R.string.tip_amount, tip),
               style = MaterialTheme.typography.displaySmall,
               modifier = Modifier.padding(15.dp)
           )
       }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        TipCalculator()
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions,
) {
    TextField(
        leadingIcon = {
            Icon(painter = painterResource(id = leadingIcon),
                null,Modifier.size(35.dp))
        },
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = {
            Text(stringResource(id = label))
        },
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}
@VisibleForTesting

//by internal keyword we can another module can not  access this specific code
internal fun calCulateTip(amount: Double,tipPercenatage: Double,roundUp: Boolean): String{
    var tip = (tipPercenatage/100)*amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun RoundUpTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier
        .fillMaxWidth()
        .size(48.dp)
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(R.string.round_up_tip)
        )
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
        )
    }
}