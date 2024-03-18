package com.example.coffeediary.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.navigation.Screen
import com.example.coffeediary.parts.RatingBar
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily
import com.example.coffeediary.ui.theme.oswaldFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(
    viewModel : CoffeeViewModel,
    navController : NavController){

    val coffeeList = viewModel.getAllCoffeeType().collectAsState(initial = emptyList())
    var menuExpanded by remember { mutableStateOf(false) }
    val sortOrder by viewModel.sortOrder.collectAsState()

    // Sort your list based on sortOrder
    val sortedList = when (sortOrder) {
        "Title" -> coffeeList.value.sortedBy { it.title }
        "Date" -> coffeeList.value.sortedBy { it.date }
        "Rating" -> coffeeList.value.sortedBy { it.ratingBar }
        else -> coffeeList.value
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "your diaries:",
                        fontFamily = bebasNeueFamily,
                        fontSize = 30.sp)
                },
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(Screen.Menu.route)}) {
                        Icon(Icons.Filled.Home, "homeIcon")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                actions = {
                    IconButton(onClick = { menuExpanded = !menuExpanded }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "DropDownMenu"
                        )
                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }) {
                        Text(
                            text = "Sort by:",
                            Modifier.padding(start = 10.dp),
                            fontFamily = bebasNeueFamily
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Title",
                                    fontFamily = oswaldFamily,
                                    fontWeight = FontWeight.Normal
                                ) },
                            onClick = {
                                viewModel.sortByTitle()
                                menuExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Date",
                                    fontFamily = oswaldFamily,
                                    fontWeight = FontWeight.Normal
                                ) },
                            onClick = {
                                viewModel.sortByDate()
                                menuExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = "Rating",
                                    fontFamily = oswaldFamily,
                                    fontWeight = FontWeight.Normal
                                ) },
                            onClick = {
                                viewModel.sortByRating()
                                menuExpanded = false
                            }
                        )
                    }
                }
            )
        }, content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp),
                content = {
                    items(
                        items = sortedList,
                        itemContent = {coffeeItem ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(0.85f)
                                    .height(100.dp)
                                    .clickable { navController.navigate("${Screen.DetailNote.route}/${coffeeItem.title}/${coffeeItem.id}") },
                                shape = RoundedCornerShape(22.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 20.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .fillMaxWidth(0.85f)
                                            .padding(vertical = 5.dp),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = coffeeItem.title,
                                            fontFamily = bebasNeueFamily,
                                            fontSize = 26.sp
                                        )
                                        Text(
                                            text = coffeeItem.location,
                                            fontFamily = bebasNeueFamily,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            fontSize = 14.sp
                                        )
                                        Text(
                                            text = coffeeItem.date.toString(),
                                            fontFamily = bebasNeueFamily,
                                            fontSize = 10.sp
                                        )
                                        RatingBar(
                                            currentRating = coffeeItem.ratingBar,
                                            onRatingChanged = {})
                                    }
                                    Spacer(modifier = Modifier.size(10.dp))
                                    Icon(
                                        imageVector = Icons.Filled.Delete,
                                        contentDescription = "delete",
                                        tint = Color.Black,
                                        modifier = Modifier
                                            .clickable(onClick = {
                                                viewModel.deleteCoffeeById(coffeeItem.id)
                                        }
                                            )
                                    )
                                }
                            }
                        }
                    )
                }
            )
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NotesPreview(){
    CoffeeDiaryTheme {
        NotesScreen(
            CoffeeViewModel(Application()),
            rememberNavController())
    }
}