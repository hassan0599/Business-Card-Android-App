package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BoogerBuster
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.Downriver

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun ProfileBlock() {
    Column (
        modifier = Modifier
            .padding(bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val profilePhoto = painterResource(R.drawable.demo_profile_pic)
            Image(
                painter = profilePhoto,
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )
        }
        Column {
            Text(
                text = stringResource(R.string.name),
                color = Color.White,
                fontSize = 24.sp
            )
            Text(
                text = stringResource(R.string.title),
                color = BoogerBuster,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun InformationRow(information: Int, drawable: Int) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 2.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(end = 10.dp),
            text = stringResource(information),
            color = Color.White,
            textAlign = TextAlign.Right,
            fontSize = 12.sp
        )
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier
                .width(15.dp)
                .height(15.dp)
        )
    }
}

@Composable
fun InformationBlock() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .padding(top = 100.dp)
    ) {
        InformationRow(R.string.number , R.drawable.ic_phone)
        InformationRow(R.string.email , R.drawable.ic_email)
        InformationRow(R.string.linkedin , R.drawable.ic_linkedin)
        InformationRow(R.string.googledeveloper , R.drawable.ic_gd)
        InformationRow(R.string.github , R.drawable.ic_github)
    }
}

@Composable
fun BusinessCard() {
    Column (
        modifier = Modifier
            .background(Downriver)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileBlock()
        InformationBlock()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}