package com.example.coffeediary.navigation

sealed class Screen(val route: String){
    object Main: Screen(
        route = "main_screen")
    object Menu: Screen(
        route = "menu_screen")
    object Notes: Screen(
        route = "notes_screen")
    object SaveNote: Screen(
        route = "save_screen")
    object DetailNote: Screen(
        route = "detail_screen")
}