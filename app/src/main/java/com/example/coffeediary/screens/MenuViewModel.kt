package com.example.coffeediary.screens

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeediary.room.model.Coffees
import com.example.coffeediary.room.model.data.repository.CoffeesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoffeeViewModel(appObj: Application) : AndroidViewModel(appObj) {

    private val coffeeRepository: CoffeesRepository = CoffeesRepository(appObj)

    // StateFlow for sort order
    private val _sortOrder = MutableStateFlow("None")
    val sortOrder: StateFlow<String> get() = _sortOrder

    // Functions to change sort order
    fun sortByTitle() {
        _sortOrder.value = "Title"
    }

    fun sortByDate() {
        _sortOrder.value = "Date"
    }

    fun sortByRating() {
        _sortOrder.value = "Rating"
    }

    fun getAllCoffeeType(): Flow<List<Coffees>> {
        return coffeeRepository.readAllCoffees
    }

    fun insertCoffee(coffees : Coffees) {
        viewModelScope.launch {
            coffeeRepository.insertCoffeeType(coffees = coffees)
        }
    }

    fun updateCoffee(id: Int, newDate: String, newLocation: String, newDescription: String, newRating: Int) {
        viewModelScope.launch {
            coffeeRepository.updateCoffee(id, newDate ,newLocation, newDescription, newRating)
        }
    }

    fun deleteCoffeeById(id : Int) {
        viewModelScope.launch {
            coffeeRepository.deleteCoffeeById(id)
        }
    }

    fun getCoffeeById(id : Int): Flow<Coffees> {
        return coffeeRepository.getCoffeeById(id)
    }

    private val _dateResult = MutableStateFlow("Select")
    val dateResult = _dateResult.asStateFlow()

    fun setDateResult(date: String) {
        _dateResult.tryEmit(date)
        Log.d("CoffeeViewModel", "DateResult has been set to: $date")
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

    private val _inputRatingBar = MutableStateFlow(0)
    val inputRatingBar = _inputRatingBar.asStateFlow()

    fun setInputRatingBar(rating: Int) {
        _inputRatingBar.tryEmit(rating)
    }

    fun clearAllInputs() {
        _inputLocation.tryEmit("")
        _inputDescription.tryEmit("")
        _inputRatingBar.tryEmit(0)
    }
}