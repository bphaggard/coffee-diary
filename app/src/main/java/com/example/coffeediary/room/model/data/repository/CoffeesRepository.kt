package com.example.coffeediary.room.model.data.repository

import android.app.Application
import com.example.coffeediary.room.model.Coffees
import com.example.coffeediary.room.model.data.local.CoffeeDao
import com.example.coffeediary.room.model.data.local.CoffeeDatabase
import kotlinx.coroutines.flow.Flow

class CoffeesRepository(application : Application) {
    private var coffeeDao: CoffeeDao

    init {
        val database = CoffeeDatabase.getDatabase(application)
        coffeeDao = database.coffeeDao()
    }

    val readAllCoffees: Flow<List<Coffees>> = coffeeDao.getAllCoffeeType()
    suspend fun insertCoffeeType(coffees : Coffees) {
        coffeeDao.insertCoffeeType(coffees)
    }

    suspend fun deleteCoffeeType(coffees : Coffees) {
        coffeeDao.deleteCoffeeType(coffees)
    }

    suspend fun deleteCoffeeById(id : Int) {
        coffeeDao.deleteCoffeeById(id)
    }

    suspend fun updateCoffeeType(coffees : Coffees) {
        coffeeDao.updateCoffeeType(coffees)
    }

    fun getCoffeeById(id: Int) {
        coffeeDao.getCoffeeTypeById(id)
    }
}