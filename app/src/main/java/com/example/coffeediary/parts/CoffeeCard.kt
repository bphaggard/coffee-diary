package com.example.coffeediary.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeediary.R
import com.example.coffeediary.ui.theme.CoffeeDiaryTheme
import com.example.coffeediary.ui.theme.bebasNeueFamily

@Composable
fun CoffeeCard(
    image: Int,
    title: String
){
    Card(
        modifier = Modifier
            .height(100.dp)
            .width(300.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            //Spacer(modifier = Modifier.padding(start = 15.dp))
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.8f),
                painter = painterResource(id = image),
                contentDescription = "coffee type")
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Text(
                modifier = Modifier
                    .padding(bottom = 47.dp)
                    .width(95.dp),
                text = title,
                fontSize = 22.sp,
                fontFamily = bebasNeueFamily)
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.scrim),
                onClick = { /*TODO*/ })
            {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "add button")
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
            title = "cappuccino"
        )
    }
}