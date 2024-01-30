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
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val rating = remember { mutableIntStateOf(0) }

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
            var enteredValue by remember { mutableStateOf("") }
            TitleValue(text = enteredValue) { value -> enteredValue = value}
//            OutlinedTextField(
//                value = titleText,
//                label = { Text(text = "Title") },
//                placeholder = { Text(text = "Input title") },
//                onValueChange = { newTitleValue ->
//                                titleText = newTitleValue
//                    onValueChange(newTitleValue)
//                },
//                colors = OutlinedTextFieldDefaults.colors(
//                    focusedTextColor = Color.Black,
//                    unfocusedTextColor = Color.Black,
//                    focusedBorderColor = Color.Black,
//                    unfocusedBorderColor = Color.Black,
//                    focusedLabelColor = Color.Black,
//                    unfocusedLabelColor = Color.Black,
//                )
//            )
            CustomDatePicker()
            OutlinedTextField(
                value = text,
                label = { Text(text = "Location") },
                placeholder = { Text(text = "Input location") },
                onValueChange = { text = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                )
            )
            OutlinedTextField(
                modifier = Modifier.height(150.dp),
                value = text,
                label = { Text(text = "Description") },
                placeholder = { Text(text = "Input description") },
                onValueChange = { text = it },
                minLines = 2,
                maxLines = 6,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                )
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Row {
                Text(
                    text = "rating:",
                    fontFamily = bebasNeueFamily,
                    fontSize = 24.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                RatingBar(
                    currentRating = rating.intValue,
                    onRatingChanged = { newRating -> rating.intValue = newRating }
                )
            }
        }
    }
}

@Composable
fun TitleValue(text: String, onValueChange: (String) -> Unit) {
    var titleValue by remember { mutableStateOf(text) }

    OutlinedTextField(
        value = titleValue,
        label = { Text(text = "Title") },
        placeholder = { Text(text = "Input title") },
        onValueChange = { newTitleValue ->
            titleValue = newTitleValue
            onValueChange(newTitleValue)
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
        )
    )
}

@Preview
@Composable
fun SavePreview(){
    CoffeeDiaryTheme {
        SaveCard(navController = rememberNavController())
    }
}