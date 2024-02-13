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

    val readCoffeesByDate: Flow<List<Coffees>> = coffeeDao.getCoffeeByDate()

    val readCoffeesByLocation: Flow<List<Coffees>> = coffeeDao.getCoffeeByLocation()
    suspend fun insertCoffeeType(coffees : Coffees) {
        coffeeDao.insertCoffeeType(coffees)
    }

    suspend fun deleteCoffeeById(id : Int) {
        coffeeDao.deleteCoffeeById(id)
    }

    fun getCoffeeById(id: Int): Flow<Coffees> {
        return coffeeDao.getCoffeeTypeById(id)
    }
}