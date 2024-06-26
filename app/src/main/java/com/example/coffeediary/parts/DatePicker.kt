package com.example.coffeediary.parts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.ZoneId

//@Composable
//fun CustomDatePicker() {
//    val date = remember { mutableStateOf("")}
//    val isOpen = remember { mutableStateOf(false)}
//
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        OutlinedTextField(
//            readOnly = true,
//            value = date.value,
//            label = { Text("Date") },
//            placeholder = { Text(text = "Input date") },
//            onValueChange = {},
//            modifier = Modifier
//                .clickable(onClick = { isOpen.value = true })
//                .height(66.dp)
//                .fillMaxWidth(0.9f),
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedTextColor = Color.Black,
//                unfocusedTextColor = Color.Black,
//                focusedBorderColor = Color.Black,
//                unfocusedBorderColor = Color.Black,
//                focusedLabelColor = Color.Black,
//                unfocusedLabelColor = Color.Black,
//            )
//        )
//    }
//
//    if (isOpen.value) {
//        CustomDatePickerDialog(
//            onAccept = {
//                isOpen.value = false // close dialog
//
//                if (it != null) {// Set the date
//                    date.value = Instant
//                        .ofEpochMilli(it)
//                        .atZone(ZoneId.systemDefault())
//                        .toLocalDate().toString()
//                }
//            },
//            onCancel = {
//                isOpen.value = false //close dialog
//            }
//        )
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomDatePickerDialog(
//    onAccept: (Long?) -> Unit,
//    onCancel: () -> Unit
//) {
//    val state = rememberDatePickerState()
//
//    DatePickerDialog(
//        onDismissRequest = { },
//        confirmButton = {
//            Button(onClick = { onAccept(state.selectedDateMillis) }) {
//                Text("Accept")
//            }
//        },
//        dismissButton = {
//            Button(onClick = onCancel) {
//                Text("Cancel")
//            }
//        }
//    ) {
//        DatePicker(state = state)
//    }
//}