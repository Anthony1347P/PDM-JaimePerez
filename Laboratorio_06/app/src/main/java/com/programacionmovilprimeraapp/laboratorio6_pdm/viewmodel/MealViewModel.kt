package com.programacionmovilprimeraapp.laboratorio6_pdm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.model.Meal
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.repository.MealRepository
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.repository.MealRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealViewModel: ViewModel(){
    private val repository: MealRepository = MealRepositoryImpl()

    private val _recetas = MutableStateFlow<List<Meal>>(emptyList())
    val recetas: StateFlow<List<Meal>> = _recetas.asStateFlow()

    private val _cargando = MutableStateFlow(false)
    val cargando: StateFlow<Boolean> = _cargando.asStateFlow()

    private val _mensajeError = MutableStateFlow<String?>(null)
    val mensajeError: StateFlow<String?> = _mensajeError.asStateFlow()

    fun cargarRecetas(){
        viewModelScope.launch {
            _cargando.value = true
            repository.getRecetas()
                .onSuccess {
                    _recetas.value = it
                    _mensajeError.value = null
                }
                .onFailure {
                    _mensajeError.value = "No se pudo cargar las recetas"
                }
            _cargando.value = false
        }
    }
}


