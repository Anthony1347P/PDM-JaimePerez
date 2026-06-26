package com.programacionmovilprimeraapp.laboratorio6_pdm.data.repository

import com.programacionmovilprimeraapp.laboratorio6_pdm.data.model.Meal

interface MealRepository {
    suspend fun getRecetas(): Result<List<Meal>>
}