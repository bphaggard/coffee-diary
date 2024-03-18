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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import coil.compose.AsyncImage
import com.example.coffeediary.R
import com.example.coffeediary.parts.RatingBar
import com.example.coffeediary.parts.titleToImageMap
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily
import com.example.coffeediary.ui.theme.oswaldFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController : NavController,
    title: String,
    itemId: Int,
    viewModel : CoffeeViewModel

) {
    val coffeeId = viewModel.getCoffeeById(itemId).collectAsState(initial = null).value

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
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
            )
        }, content = {innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(200.dp),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                ) {
                    val imageResource = titleToImageMap[title] ?: R.drawable.espresso
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = imageResource,
                            modifier = Modifier
                                .fillMaxSize(0.85f),
                            contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.padding(15.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.85f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    content = {
                        items(
                            items = listOfNotNull(coffeeId),
                            itemContent = {coffeeItem ->
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(0.7f)
                                        ) {
//                                            Text(
//                                                text = coffeeItem.location,
//                                                fontFamily = oswaldFamily,
//                                                fontWeight = FontWeight.Light,
//                                                maxLines = 1,
//                                                overflow = TextOverflow.Ellipsis
//                                            )
                                            LocationExpandedText(
                                                text = coffeeItem.location
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Column(
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Text(
                                                text = coffeeItem.date.toString(),
                                                fontFamily = oswaldFamily,
                                                fontWeight = FontWeight.Light
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Row {
                                        Text(
                                            text = "rating:",
                                            fontFamily = oswaldFamily,
                                            fontWeight = FontWeight.Light,
                                            fontSize = 16.sp)
                                        Spacer(modifier = Modifier.padding(5.dp))
                                        RatingBar(
                                            currentRating = coffeeItem.ratingBar,
                                            onRatingChanged = {  }
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Text(
                                        text = coffeeItem.description,
                                        fontFamily = oswaldFamily,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 20.sp
                                    )
                                }
                            }
                        )
                    }
                )
            }
        }
    )
}

@Composable
fun LocationExpandedText(text: String) {
    var isExpanded by remember { mutableStateOf(false) }

    Text(
        text = text,
        fontFamily = oswaldFamily,
        fontWeight = FontWeight.Light,
        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.clickable { isExpanded = !isExpanded }
    )
}


@Preview(showBackground = true)
@Composable
fun DetailPreview(){
    CoffeeDiaryTheme {
        DetailScreen(
            navController = rememberNavController(),
            title = "Detail note",
            itemId = 1,
            viewModel = CoffeeViewModel(Application())
        )
    }
}