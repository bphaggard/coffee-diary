package com.example.coffeediary.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "coffees")
data class Coffees(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val location: String,
    val description: String,
    val date: LocalDate = LocalDate.now()
)