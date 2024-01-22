package com.example.coffeediary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.navigation.NavGraph
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeDiaryTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}