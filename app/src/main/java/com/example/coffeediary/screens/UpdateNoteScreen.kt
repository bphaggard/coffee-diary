package com.example.coffeediary.screens

import android.annotation.SuppressLint
import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.bounceClick
import com.example.coffeediary.navigation.Screen
import com.example.coffeediary.parts.RatingBar
import com.example.coffeediary.parts.Tools
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@SuppressLint("StateFlowValueCalledInComposition" , "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    navController : NavController,
    itemId: Int,
    viewModel: CoffeeViewModel
) {
    val context = LocalContext.current
    val coffeeId = viewModel.getCoffeeById(itemId).collectAsState(initial = null).value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Update Note",
                        fontFamily = bebasNeueFamily,
                        fontSize = 30.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (navController.canGoBack) {
                                navController.popBackStack()
                            }
                        }
                    )
                    {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
            )
        }, content = {innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                content = {
                    items(
                        items = listOfNotNull(coffeeId),
                        itemContent = {coffeeItem ->
                            var newLocation by remember { mutableStateOf(coffeeItem.location) }
                            var newDescription by remember { mutableStateOf(coffeeItem.description) }
                            var newRating by remember { mutableIntStateOf(coffeeItem.ratingBar) }
                            val openDialog = remember { mutableStateOf(false) }
                            Card(
                                modifier = Modifier
                                    .height(380.dp)
                                    .fillMaxWidth(0.85f),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(15.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Spacer(modifier = Modifier.padding(top = 15.dp))
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
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .height(66.dp)
                                            .fillMaxWidth(0.9f),
                                        maxLines = 1,
                                        value = newLocation,
                                        label = { Text(text = "Location") },
                                        placeholder = { Text(text = "Input location") },
                                        onValueChange = { newValue ->
                                            newLocation = newValue },
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
                                        modifier = Modifier
                                            .height(150.dp)
                                            .fillMaxWidth(0.9f),
                                        value = newDescription,
                                        label = { Text(text = "Description") },
                                        placeholder = { Text(text = "Input description") },
                                        onValueChange = { newValue ->
                                            newDescription = newValue },
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
                                    Spacer(modifier = Modifier.padding(10.dp))
                                    Row {
                                        Text(
                                            text = "rating:",
                                            fontFamily = bebasNeueFamily,
                                            fontSize = 24.sp)
                                        Spacer(modifier = Modifier.padding(5.dp))
                                        RatingBar(
                                            currentRating = newRating,
                                            onRatingChanged = { newValue ->
                                                newRating = newValue
                                            }
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.padding(15.dp))
                            Button(
                                modifier = Modifier.bounceClick() ,
                                onClick = {
                                    viewModel.updateCoffee(coffeeItem.id,newLocation, newDescription, newRating)
                                    Toast.makeText(context,"Successfully updated", Toast.LENGTH_SHORT).show()
                                    navController.navigate(Screen.Notes.route)
                                } ,
                                shape = RoundedCornerShape(20.dp) ,
                                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                            ) {
                                Text(
                                    text = "update note" ,
                                    fontFamily = bebasNeueFamily ,
                                    fontSize = 26.sp
                                )
                            }
                        }
                    )
                }
            )
        }
    )
}

private val NavController.canGoBack: Boolean // pokud vícekrát klikneme na back button, vráti nás to jen o jeden klik
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun UpdatePrev() {
    CoffeeDiaryTheme {
        UpdateScreen(
            navController = rememberNavController(),
            itemId = 1,
            viewModel = CoffeeViewModel(appObj = Application())
        )
    }
}