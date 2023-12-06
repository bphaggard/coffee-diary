package com.example.coffeediary.parts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@Composable
fun SaveCard(
    navController : NavController
){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val rating = remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .height(430.dp)
            .fillMaxWidth(0.85f),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 20.dp))
            OutlinedTextField(
                value = text,
                label = { Text(text = "Input title") },
                placeholder = { Text(text = "Title") },
                onValueChange = { text = it })
            OutlinedTextField(
                value = text,
                label = { Text(text = "Input date") },
                placeholder = { Text(text = "Date") },
                onValueChange = { text = it })
            OutlinedTextField(
                value = text,
                label = { Text(text = "Input location") },
                placeholder = { Text(text = "Location") },
                onValueChange = { text = it })
            OutlinedTextField(
                modifier = Modifier.height(150.dp),
                value = text,
                label = { Text(text = "Input description") },
                placeholder = { Text(text = "Description") },
                onValueChange = { text = it },
                minLines = 2,
                maxLines = 6)
            Spacer(modifier = Modifier.padding(5.dp))
            Row {
                Text(
                    text = "rating:",
                    fontFamily = bebasNeueFamily,
                    fontSize = 24.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                RatingBar(
                    currentRating = rating.value,
                    onRatingChanged = { newRating -> rating.value = newRating }
                )
            }
        }
    }
}

@Preview
@Composable
fun SavePreview(){
    CoffeeDiaryTheme {
        SaveCard(navController = rememberNavController())
    }
}