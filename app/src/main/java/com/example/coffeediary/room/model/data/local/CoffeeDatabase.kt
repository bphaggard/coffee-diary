package com.example.coffeediary.room.model.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coffeediary.room.model.Coffees

@Database(entities = [Coffees::class], version = 1)
abstract class CoffeeDatabase : RoomDatabase() {

    abstract fun coffeeDao(): CoffeeDao

    companion object {
        private var INSTANCE: CoffeeDatabase? = null
        fun getInstance(context: Context): CoffeeDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, CoffeeDatabase::class.java, "coffee.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as CoffeeDatabase
        }
    }
}

//@Database(entities = [Coffees::class], version = 1, exportSchema = true)
//abstract class CoffeeDatabase: RoomDatabase() {
//    abstract fun coffeeDao(): CoffeeDao
//}