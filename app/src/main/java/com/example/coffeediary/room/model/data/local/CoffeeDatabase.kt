package com.example.coffeediary.room.model.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeediary.room.model.Coffees

@Database(entities = [Coffees::class], version = 1, exportSchema = true)
abstract class CoffeeDatabase: RoomDatabase() {
    abstract fun coffeeDao(): CoffeeDao
}