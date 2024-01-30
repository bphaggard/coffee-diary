package com.example.coffeediary

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.coffeediary.room.model.Coffees
import com.example.coffeediary.room.model.data.repository.CoffeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


interface MainViewModelAbstract {
    val coffeeListFlow: Flow<List<Coffees>>
    fun addCoffee(coffees : Coffees)
    //suspend fun chooseCoffee()
    fun deleteCoffee(coffees : Coffees)
}

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val coffeeRepository : CoffeeRepository
): ViewModel(), MainViewModelAbstract {

    override val coffeeListFlow : Flow<List<Coffees>> = coffeeRepository.getAllCoffeeTypes()

    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _chosenId = mutableStateOf<Int?>(null)

    var chosenId: MutableState<Int?> = _chosenId
    override fun addCoffee(coffees : Coffees) {
        ioScope.launch { coffeeRepository.insertCoffee(coffees = coffees) }
    }

//    override suspend fun chooseCoffee() {
//        val selectedCoffee = coffeeRepository.getCoffeeById(id = 0)
//        _chosenId.value = selectedCoffee
//    }

    override fun deleteCoffee(coffees : Coffees) {
        ioScope.launch { coffeeRepository.deleteCoffee(coffees = coffees) }
    }
}