package com.example.coffeediary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.navigation.Screen
import com.example.coffeediary.screens.CoffeeViewModel
import com.example.coffeediary.screens.DetailScreen
import com.example.coffeediary.screens.MainScreen
import com.example.coffeediary.screens.MenuScreen
import com.example.coffeediary.screens.SaveNoteScreen
import com.example.coffeediary.screens.NotesScreen
import com.example.coffeediary.screens.UpdateScreen
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[CoffeeViewModel::class.java]

        setContent {
            CoffeeDiaryTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Main.route
                ){
                    composable(
                        route = Screen.Main.route
                    ){
                        MainScreen(navController)
                    }
                    composable(
                        route = Screen.Menu.route
                    ){
                        MenuScreen(navController)
                    }
                    composable(
                        "${Screen.SaveNote.route}/{title}"
                    ) { navBackStackEntry ->
                        val title = navBackStackEntry.arguments?.getString("title")
                        SaveNoteScreen(navController, title ?: "", viewModel)
                    }
                    composable(
                        route = "${ Screen.UpdateNote.route }/{id}"
                    ){navBackStackEntry ->
                        val idString = navBackStackEntry.arguments?.getString("id")
                        val id = idString?.toIntOrNull()
                        if (id != null) {
                            UpdateScreen(navController, id,viewModel)
                        }
                    }
                    composable(
                        route = Screen.Notes.route
                    ){
                        NotesScreen(viewModel, navController)
                    }
                    composable(
                        route = "${ Screen.DetailNote.route }/{title}/{id}"
                    ){navBackStackEntry ->
                        val title = navBackStackEntry.arguments?.getString("title")
                        val idString = navBackStackEntry.arguments?.getString("id")
                        val id = idString?.toIntOrNull()
                        if (id != null) {
                            DetailScreen(navController, title ?: "", itemId = id, viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}