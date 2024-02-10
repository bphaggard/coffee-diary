package com.example.coffeediary.screens

import android.app.Application
import androidx.compose.runtime.mutableStateOf
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
    val inputTitle = _inputTitle
    fun setInputTitle(title: String) {
        _inputTitle.tryEmit(title)
    }

    private val _inputLocation = MutableStateFlow("")
    val inputLocation = _inputLocation.asStateFlow()
    fun setInputLocation(location: String) {
        _inputLocation.tryEmit(location)
    }

    private val _inputDescription = MutableStateFlow("")
    val inputDescription = _inputDescription.asStateFlow()

    fun setInputDescription(desc: String) {
        _inputDescription.tryEmit(desc)
    }
}