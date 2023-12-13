package com.example.coffeediary.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme

@Composable
fun NotesScreen(){
    Text(text = "Notes")
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NotesPreview(){
    CoffeeDiaryTheme {
        NotesScreen()
    }
}