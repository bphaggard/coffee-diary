package com.example.coffeediary.room.model.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.coffeediary.room.model.Coffees
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffeeType(coffees : Coffees)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCoffeeType(coffees : Coffees)

    @Delete
    suspend fun deleteCoffeeType(coffees : Coffees)

    @Query("SELECT * FROM Coffees WHERE id = :id")
    suspend fun getCoffeeTypeById(id: Int): Coffees

    @Query("SELECT * FROM Coffees")
    fun getAllCoffeeType(): Flow<List<Coffees>>
}