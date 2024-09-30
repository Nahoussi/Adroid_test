package com.example.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   /* GreetingImage(
                        message = "Happy Birthday sonia!",
                        from = "From Angie"
                    )
                    DiceWithButtonAndImage()
                    TipTimeLayout()*/
                    GreetingGallerie()

                }
            }
        }
    }
}







@Preview(showBackground = true, name = "hbd")
@Composable
fun BirthdayCardPreview() {
    TestTheme {
       // GreetingImage(message = "Happy Birthday sonia!", from = "From Angie")
        //DiceWithButtonAndImage()
         //GreetingCartes(texte = "")
        //TipTimeLayout()
        GreetingGallerie()

    }
}


@Composable
fun GreetingText(message: String,from:String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement= Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 90.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            textAlign = TextAlign.End

        )
    }
}
@Composable
fun GreetingImage(message: String, from: String,modifier:Modifier=Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier){
        Image(
            painter = image,
            contentDescription = null
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}




@Composable
fun GreetingArticle(sms: String,  modif:Modifier=Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modif.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "Jetpack Compose tutorial",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.articl_content2),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)

        )
        Text(
            text = stringResource(R.string.article_content),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)

        )

    }
}
@Composable
fun GreetingTaches(texte: String,  modif:Modifier=Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = null,

        )
        Text(
            text = "All tasks completed",



            modifier = Modifier.padding(top=24.dp, bottom = 6.dp),

        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)

        )
    }
}


@Composable
fun GreetingCartes(texte: String,  modif:Modifier=Modifier) {
    val image = painterResource(R.drawable.ic_launcher_foreground)
    val im = painterResource(R.drawable.call_24dp_e8eaed)
    Column(modif.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,

            contentDescription = null

        )
        Text(
            text = "NAHOUSSI Sonia",



            modifier = Modifier.padding(top=24.dp, bottom = 4.dp),

            )
        Text(
            text = "Android connecte",
            fontSize = 10.sp,


        )
        Text(
            text = " 657660099",
            fontSize = 14.sp,
            modifier = Modifier.padding(top=100.dp)

            )
        Text(
            text = " sonifanga@gmail.com",
            fontSize = 14.sp,


        )
    }
}



@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))

        }
    }
}




    private fun enableEdgeToEdge() {
        TODO("Not yet implemented")
    }


@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercent, roundUp)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.tip_amount, "$0.00"),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)

        )
        EditNumberField(
            label = R.string.bill_amount,
            leadingIcon = R.drawable.money,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = amountInput,
            onValueChanged = { amountInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
        )
        EditNumberField(
            label = R.string.how_was_the_service,
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            value = tipInput,
            onValueChanged = { tipInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
        )
        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(


    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var amountInput by remember {
        mutableStateOf("")
    }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount= amount,roundUp=false)

    TextField(

        value = amountInput,
        singleLine = true,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { amountInput = it},
        label = { Text(text = stringResource(id = R.string.bill_amount)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged
        )
    }
}

/**
 * Calculates the tip based on the user input and format the tip amount
 * according to the local currency.
 * Example would be "$10.00".
 */
private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    /*if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }*/
    return NumberFormat.getCurrencyInstance().format(tip)
}



@Composable
fun GreetingGallerie(  modif:Modifier=Modifier) {
    //val image = painterResource(R.drawable.mona_lisa)
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.mona_lisa
        2 -> R.drawable.oeuvres

        else -> R.drawable.oeuvres2
    }
    Column(modif.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        when (result){
            1 -> println(
                Column {
                    Text(
                        text = "MONA LISA",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(16.dp)


                    )
                    Text(
                        text = stringResource(R.string.auteur),
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(16.dp)

                    )
                    Text(
                        text = stringResource(R.string.histoire),
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 12.sp,
                    )
                }


            )
            2 -> println(
                Column {
                    Text(
                        text = "MONA",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(16.dp)


                    )
                    Text(
                        text = stringResource(R.string.acteur),
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(16.dp)

                    )
                    Text(
                        text = stringResource(R.string.hist),
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 12.sp,
                    )
                }
            )
            else -> println(
                Column {
                    Text(
                        text = "LISA",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(16.dp)


                    )
                    Text(
                        text = stringResource(R.string.artiste),
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(16.dp)

                    )
                    Text(
                        text = stringResource(R.string.hist3),
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 12.sp,
                    )
                }
            )
        }


        Row (modifier = Modifier.padding(30.dp)
        ){
            Button(onClick = {result = (1..3).random() }) {
                Text(stringResource(R.string.retour))
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(onClick = {result = (1..3).random() }) {
                Text(stringResource(R.string.suivant))

            }
        }

    }
}