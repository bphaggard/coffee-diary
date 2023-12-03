package com.example.coffeediary.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.R
import com.example.coffeediary.bottomBar.Screen
import com.example.coffeediary.bounceClick
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily
import com.example.coffeediary.ui.theme.djbCoffeeFamily

@Composable
fun MainScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "coffee diary",
            fontFamily = djbCoffeeFamily,
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        Image(
            modifier = Modifier.fillMaxWidth(0.8f),
            painter = painterResource(id = R.drawable.cap2),
            contentDescription = "Main Image"
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Button(
            modifier = Modifier
                .width(200.dp)
                .bounceClick(),
            onClick = { navController.navigate(Screen.Menu.route) },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
        )
        {
            Text(
                text = "Get Started",
                fontFamily = bebasNeueFamily,
                fontSize = 26.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview(){
    CoffeeDiaryTheme {
        MainScreen(navController = rememberNavController())
    }
}