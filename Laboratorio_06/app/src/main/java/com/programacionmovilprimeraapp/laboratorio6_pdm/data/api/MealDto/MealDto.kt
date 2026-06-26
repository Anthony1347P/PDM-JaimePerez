package com.programacionmovilprimeraapp.laboratorio6_pdm.data.api.MealDto

import com.programacionmovilprimeraapp.laboratorio6_pdm.data.model.Meal
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.model.MealCompleteModel
import kotlinx.serialization.Serializable

@Serializable
data class MealDto(
    val meals: List<MealContentDto>
)

@Serializable
data class MealContentDto(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String ?,
    val strArea: String ?,
    val strMealThumb: String
)


fun MealDto.toMealCompleteModel(): MealCompleteModel {
    return MealCompleteModel(
        meals = meals.map { it.toMeal() }
    )
}

fun MealContentDto.toMeal(): Meal {
    return Meal(
        id = idMeal,
        nombre = strMeal,
        imagenUrl = strMealThumb
    )
}
