package com.example.coffeediary.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.coffeediary.navigation.CustomBottomNavigation
import com.example.coffeediary.parts.CoffeeCard
import com.example.coffeediary.parts.coffeeItems
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuScreen(navController : NavController) {

    Scaffold(
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ){
                item {
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Text(
                        modifier = Modifier.padding(end = 80.dp),
                        text = "choose your coffee:",
                        fontFamily = bebasNeueFamily,
                        fontSize = 30.sp
                    )
                }
                items(coffeeItems){coffeeItem ->
                    CoffeeCard(
                        image = coffeeItem.imageId,
                        title = coffeeItem.title,
                        navController = navController)
                }
            }
        },
        bottomBar = {
            CustomBottomNavigation(navController = navController)
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MenuPreview(){
    CoffeeDiaryTheme {
        MenuScreen(navController = rememberNavController())
    }
}