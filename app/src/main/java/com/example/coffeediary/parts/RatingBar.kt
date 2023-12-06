package com.example.coffeediary.parts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int = 0,
    onRatingChanged: (Int) -> Unit
) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= currentRating) Icons.Filled.Star else Icons.Filled.Star,
                contentDescription = "Rating Star",
                tint = if (i <= currentRating) androidx.compose.ui.graphics.Color.Yellow else androidx.compose.ui.graphics.Color.Gray,
                modifier = androidx.compose.ui.Modifier
                    .padding(4.dp)
                    .clickable { onRatingChanged(i) }
            )
        }
    }
}