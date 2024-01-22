package com.example.coffeediary.room.model.data.repository

import com.example.coffeediary.room.model.Coffees
import com.example.coffeediary.room.model.data.local.CoffeeDao
import kotlinx.coroutines.flow.Flow

class CoffeeRepository(
    private val dao : CoffeeDao
) {
    suspend fun insertCoffee(coffees : Coffees) : Unit = dao.insertCoffeeType(coffees = coffees)

    suspend fun updateCoffee(coffees : Coffees) : Unit = dao.updateCoffeeType(coffees = coffees)

    suspend fun deleteCoffee(coffees : Coffees) : Unit = dao.deleteCoffeeType(coffees = coffees)

    suspend fun getCoffeeById(id : Int) : Coffees = dao.getCoffeeTypeById(id = id)

    fun getAllCoffeeTypes(): Flow<List<Coffees>> = dao.getAllCoffeeType()
}