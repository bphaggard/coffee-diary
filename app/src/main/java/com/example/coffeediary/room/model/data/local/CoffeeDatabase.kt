package com.example.coffeediary.room.model.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coffeediary.parts.Converters
import com.example.coffeediary.room.model.Coffees

@Database(entities = [Coffees::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CoffeeDatabase : RoomDatabase() {

    abstract fun coffeeDao(): CoffeeDao

    companion object {
        @Volatile
        private var INSTANCE: CoffeeDatabase? = null
        fun getDatabase(context: Context): CoffeeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    CoffeeDatabase::class.java, "coffee_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}