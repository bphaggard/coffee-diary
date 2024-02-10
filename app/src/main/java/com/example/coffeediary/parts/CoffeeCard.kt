package com.example.coffeediary.parts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.coffeediary.R
import com.example.coffeediary.navigation.Screen
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@Composable
fun CoffeeCard(
    image : Int,
    title : String,
    navController : NavController
){
    Card(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .wrapContentHeight(Alignment.CenterVertically),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            AsyncImage(
                model = image,
                modifier = Modifier
                    .size(100.dp),
                contentDescription = null)
            //Spacer(modifier = Modifier.padding(start = 20.dp))
            Text(
                modifier = Modifier
                    .padding(bottom = 47.dp)
                    .width(95.dp),
                text = title,
                fontSize = 22.sp,
                fontFamily = bebasNeueFamily)
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.scrim),
                onClick = { navController.navigate("${Screen.SaveNote.route}/$title") })
            {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "add button",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun MainPreview(){
    CoffeeDiaryTheme {
        CoffeeCard(
            image = R.drawable.espresso,
            title = "cappuccino",
            navController = rememberNavController()
        )
    }
}