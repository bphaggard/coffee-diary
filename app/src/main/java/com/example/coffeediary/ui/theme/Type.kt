package com.example.coffeediary.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.coffeediary.R

val bebasNeueFamily = FontFamily(
    Font(R.font.bebasneue, FontWeight.Normal)
)

val djbCoffeeFamily = FontFamily(
    Font(R.font.djbcoffee, FontWeight.Normal)
)

val oswaldFamily = FontFamily(
    Font(R.font.oswald_extralight, FontWeight.ExtraLight),
    Font(R.font.oswald_light, FontWeight.Light),
    Font(R.font.oswald_medium, FontWeight.Medium),
    Font(R.font.oswald_regular, FontWeight.Normal),
    Font(R.font.oswald_bold, FontWeight.Bold),
    Font(R.font.oswald_semibold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)