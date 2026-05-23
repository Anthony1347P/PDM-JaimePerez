package com.pdm0126.labo4_00202124.ViewModel

import androidx.lifecycle.ViewModel
import com.pdm0126.labo4_00202124.Model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    val tasks = _tasks.asStateFlow()

    fun addTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { add(task) }
    }
}