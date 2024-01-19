package com.example.coffeediary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coffeediary.screens.MainScreen
import com.example.coffeediary.screens.MenuScreen
import com.example.coffeediary.screens.NotesScreen
import com.example.coffeediary.screens.SaveNoteScreen

@Composable
fun NavGraph(navController : NavHostController){

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
            SaveNoteScreen(navController, title ?: "")
        }
        composable(
            route = Screen.Notes.route
        ){
            NotesScreen(navController)
        }
    }
}