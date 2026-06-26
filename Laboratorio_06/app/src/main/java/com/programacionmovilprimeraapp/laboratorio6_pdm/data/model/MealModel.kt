package com.programacionmovilprimeraapp.laboratorio6_pdm.data.model

data class MealCompleteModel(
    val meals: List<Meal>
)

data class Meal(
    val id: String,
    val nombre: String,
    val imagenUrl: String
)