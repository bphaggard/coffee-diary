package com.example.coffeediary.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material.icons.outlined.Details
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material.icons.outlined.TextSnippet
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector
){
    object Main: Screen(
        title = "Main",
        route = "main_screen",
        selectedIcon = Icons.Filled.Menu,
        unselectedIcon = Icons.Outlined.Menu)
    object Menu: Screen(
        title = "Menu",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = "menu_screen")
    object Notes: Screen(
        title = "Notes",
        selectedIcon = Icons.Filled.TextSnippet,
        unselectedIcon = Icons.Outlined.TextSnippet,
        route = "notes_screen")
    object SaveNote: Screen(
        title = "Save",
        selectedIcon = Icons.Filled.Save,
        unselectedIcon = Icons.Outlined.Save,
        route = "save_screen")
    object DetailNote: Screen(
        title = "Detail",
        selectedIcon = Icons.Filled.Details,
        unselectedIcon = Icons.Outlined.Details,
        route = "detail_screen")
}