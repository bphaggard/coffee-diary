package com.example.coffeediary.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeediary.room.model.Coffees
import com.example.coffeediary.room.model.data.repository.CoffeesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoffeeViewModel(appObj: Application) : AndroidViewModel(appObj) {

    private val coffeeRepository: CoffeesRepository = CoffeesRepository(appObj)

    fun getAllCoffeeType(): Flow<List<Coffees>> {
        return coffeeRepository.readAllCoffees
    }

    fun insertCoffee(coffees : Coffees) {
        viewModelScope.launch {
            coffeeRepository.insertCoffeeType(coffees = coffees)
        }
    }

    fun updateCoffee(coffees : Coffees) {
        viewModelScope.launch {
            coffeeRepository.updateCoffeeType(coffees = coffees)
        }
    }

    fun deleteCoffee(coffees : Coffees) {
        viewModelScope.launch {
            coffeeRepository.deleteCoffeeType(coffees)
        }
    }

    fun deleteCoffeeById(id : Int) {
        viewModelScope.launch {
            coffeeRepository.deleteCoffeeById(id)
        }
    }

    fun getCoffeeById(id : Int) {
        viewModelScope.launch {
            coffeeRepository.getCoffeeById(id)
        }
    }

    private val _inputTitle = MutableStateFlow("")
    val inputTitle = _inputTitle.asStateFlow()

    fun setTitle(title: String) {
        _inputTitle.value = title
    }
}