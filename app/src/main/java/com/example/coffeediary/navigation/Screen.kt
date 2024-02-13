package com.example.coffeediary.navigation

sealed class Screen(
    val route: String,
    val title: String
){
    data object Main: Screen(
        title = "Main",
        route = "main_screen")
    data object Menu: Screen(
        title = "Menu",
        route = "menu_screen")
    data object Notes: Screen(
        title = "Notes",
        route = "notes_screen")
    data object SaveNote: Screen(
        title = "Save",
        route = "save_screen/{title}")
    data object DetailNote: Screen(
        title = "Detail",
        route = "detail_screen/{title}")
}