package com.example.coffeediary.parts

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeediary.screens.CoffeeViewModel
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("UnrememberedMutableState" , "StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDemo(viewModel: CoffeeViewModel) {

    val openDialog = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp) ,
            onClick = {
                openDialog.value = true
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Date: ${viewModel.dateResult.value}",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }

    if (openDialog.value) {
        val datePickerState = rememberDatePickerState()
        val confirmEnabled =
            derivedStateOf { datePickerState.selectedDateMillis != null }

        DatePickerDialog(
            onDismissRequest = { openDialog.value = false } ,
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    var date = "No Selection"
                    if (datePickerState.selectedDateMillis != null) {
                        date = Tools.convertLongToTime(datePickerState.selectedDateMillis!!)
                    }
                    viewModel.setDateResult(date)
                },
                    enabled = confirmEnabled.value
                    ) {
                        Text(
                            text = "Accept",
                            color = MaterialTheme.colorScheme.onBackground)
                }
            }
        ) {
                DatePicker(state = datePickerState)
        }
    }
}

class Tools {
    companion object {
        fun openLink(mContext: Context, url: String) {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(url)
            mContext.startActivity(openURL)
        }

        @SuppressLint("SimpleDateFormat")
        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("dd.MM.yyyy")
            return format.format(date)
        }
    }
}