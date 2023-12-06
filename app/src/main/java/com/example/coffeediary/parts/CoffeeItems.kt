package com.example.coffeediary.parts

import com.example.coffeediary.R

data class CoffeeItem(val imageId: Int, val title: String)

val coffeeItems = listOf(
    CoffeeItem(R.drawable.espresso, "Espresso"),
    CoffeeItem(R.drawable.americano, "Americano"),
    CoffeeItem(R.drawable.cappuccino, "Cappuccino"),
    CoffeeItem(R.drawable.latte, "Latte"),
    CoffeeItem(R.drawable.flatwhite, "Flat White"),
    CoffeeItem(R.drawable.chocolatte, "Chocolatte")
)

