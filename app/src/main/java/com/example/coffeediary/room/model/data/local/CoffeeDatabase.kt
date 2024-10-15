package com.example.coffeediary.room.model.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.coffeediary.parts.Converters
import com.example.coffeediary.room.model.Coffees

@Database(entities = [Coffees::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CoffeeDatabase : RoomDatabase() {

    abstract fun coffeeDao(): CoffeeDao

    companion object {

        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(db : SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE coffees ADD COLUMN ratingBar INTEGER NOT NULL DEFAULT(0)")
            }

        }

        private val migration_2_3 = object : Migration(2, 3) {
            override fun migrate(db : SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE coffees ADD COLUMN imagePath TEXT NOT NULL DEFAULT('')")
            }

        }

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
                    .addMigrations(migration_1_2, migration_2_3)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}