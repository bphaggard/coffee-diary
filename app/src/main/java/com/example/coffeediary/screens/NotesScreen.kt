package com.example.coffeediary.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@Composable
fun NotesScreen(navController : NavController){
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
                        modifier = Modifier.padding(end = 160.dp),
                        text = "your diaries:",
                        fontFamily = bebasNeueFamily,
                        fontSize = 30.sp
                    )
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
fun NotesPreview(){
    CoffeeDiaryTheme {
        NotesScreen(navController = rememberNavController())
    }
}