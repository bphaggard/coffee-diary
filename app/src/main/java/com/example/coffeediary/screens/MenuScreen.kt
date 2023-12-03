package com.example.coffeediary.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.R
import com.example.coffeediary.parts.CoffeeCard
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuScreen(navController: NavController){

    Scaffold(


    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.secondaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                modifier = Modifier.padding(end = 80.dp),
                text = "choose your coffee:",
                fontFamily = bebasNeueFamily,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CoffeeCard(
                image = R.drawable.espresso,
                title = "espresso"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CoffeeCard(
                image = R.drawable.americano,
                title = "americano"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CoffeeCard(
                image = R.drawable.cappuccino,
                title = "cappuccino"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CoffeeCard(
                image = R.drawable.latte,
                title = "latte"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CoffeeCard(
                image = R.drawable.flatwhite,
                title = "flat white"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CoffeeCard(
                image = R.drawable.chocolatte,
                title = "chocolatte"
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MenuPreview(){
    CoffeeDiaryTheme {
        MenuScreen(navController = rememberNavController())
    }
}