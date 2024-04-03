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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCoffeeType(coffees : Coffees)

    @Update
    suspend fun updateCoffeeType(coffees : Coffees)

    @Delete
    suspend fun deleteCoffeeType(coffees : Coffees)

    @Query("SELECT * FROM Coffees WHERE id = :id")
    fun getCoffeeTypeById(id: Int): Flow<Coffees>

    @Query("SELECT * FROM Coffees ORDER BY TITLE")
    fun getAllCoffeeType(): Flow<List<Coffees>>

    @Query("DELETE FROM Coffees WHERE id = :id")
    suspend fun deleteCoffeeById(id : Int)

    @Query("SELECT * FROM Coffees ORDER BY DATE")
    fun getCoffeeByDate(): Flow<List<Coffees>>

    @Query("SELECT * FROM Coffees ORDER BY LOCATION")
    fun getCoffeeByLocation(): Flow<List<Coffees>>

    @Query("UPDATE Coffees SET date = :newDate, location = :newLocation, description = :newDescription, ratingBar = :newRating WHERE id = :coffeeId")
    suspend fun updateCoffee(coffeeId: Int, newDate:String, newLocation: String, newDescription: String, newRating: Int)
}