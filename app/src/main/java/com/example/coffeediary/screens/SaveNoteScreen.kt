package com.example.coffeediary.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeediary.bounceClick
import com.example.coffeediary.navigation.Screen
import com.example.coffeediary.parts.SaveCard
import com.example.coffeediary.room.model.Coffees
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SaveNoteScreen(
    navController : NavController,
    title: String,
    viewModel: CoffeeViewModel
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title,
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
                    })
                    {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
            )
        }, content = {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SaveCard(viewModel)
            Spacer(modifier = Modifier.padding(15.dp))
            Button(
                modifier = Modifier.bounceClick(),
                onClick = {
                    viewModel.insertCoffee(
                        Coffees(
                            title = title,
                            location = viewModel.inputLocation.value,
                            description = viewModel.inputDescription.value,
                            date = viewModel.dateResult.value,
                            ratingBar = viewModel.inputRatingBar.value
                        )
                    )
                    navController.navigate(Screen.Notes.route)
                    viewModel.clearAllInputs()
                          },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
            ) {
                Text(
                    text = "save note",
                    fontFamily = bebasNeueFamily,
                    fontSize = 26.sp
                )
            }
        }
    })
}

private val NavController.canGoBack: Boolean // pokud vícekrát klikneme na back button, vráti nás to jen o jeden klik
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

@Preview
@Composable
fun SavePreview(){
    CoffeeDiaryTheme {
        SaveNoteScreen(
            navController = rememberNavController(),
            title = "Coffee",
            viewModel = CoffeeViewModel(appObj = Application())
        )
    }
}