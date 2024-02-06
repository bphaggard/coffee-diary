package com.example.coffeediary.screens.note_list

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.navigation.Screen
import com.example.coffeediary.screens.CoffeeViewModel
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(
    viewModel : CoffeeViewModel,
    navController : NavController){

    val coffeeList = viewModel.getAllCoffeeType().collectAsState(initial = emptyList())

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
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
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
                        items = coffeeList.value,
                        itemContent = {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(0.85f)
                                    .height(80.dp),
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
                                        modifier = Modifier. fillMaxHeight(),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = it.title,
                                            fontFamily = bebasNeueFamily,
                                            fontSize = 26.sp
                                        )
                                        Text(
                                            text = it.location,
                                            fontFamily = bebasNeueFamily,
                                            fontSize = 14.sp
                                        )
                                        Text(
                                            text = it.date.toString(),
                                            fontFamily = bebasNeueFamily,
                                            fontSize = 10.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.size(10.dp))
                                    Icon(
                                        imageVector = Icons.Filled.Delete,
                                        contentDescription = "delete",
                                        tint = Color.Black,
                                        modifier = Modifier
                                            .clickable(onClick = {
                                                viewModel.deleteCoffeeById(it.id)
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