package com.example.androidproject.presentation.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androidproject.data.model.NumberItem

class NumberViewModel: ViewModel() {
    private val _numbers = mutableListOf<NumberItem>()

    val numbers: List<NumberItem> get() = _numbers

    fun addNumberItem(){
        val newId = if (_numbers.isEmpty()) 0 else _numbers.last().id + 1
        _numbers.add(NumberItem(newId, newId % 2 == 0))
    }
}