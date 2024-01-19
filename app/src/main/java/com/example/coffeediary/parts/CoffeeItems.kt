package com.example.coffeediary.parts

import com.example.coffeediary.R

data class CoffeeItem(
    val id: Int,
    val imageId: Int,
    val title: String)

val coffeeItems = arrayListOf(
    CoffeeItem(0, R.drawable.espresso, "Espresso"),
    CoffeeItem(1, R.drawable.americano, "Americano"),
    CoffeeItem(2, R.drawable.cappuccino, "Cappuccino"),
    CoffeeItem(3, R.drawable.latte, "Latte"),
    CoffeeItem(4, R.drawable.flatwhite, "Flat White"),
    CoffeeItem(5, R.drawable.chocolatte, "Chocolatte")
)

