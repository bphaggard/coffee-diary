package com.example.coffeediary.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffees")
data class Coffees(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0 ,
    val title : String ,
    val location : String ,
    val description : String ,
    val date : String ,
    val ratingBar : Int,
    val imagePath: String
)