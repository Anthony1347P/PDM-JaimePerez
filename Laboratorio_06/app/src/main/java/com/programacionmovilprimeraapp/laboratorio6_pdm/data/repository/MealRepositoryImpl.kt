package com.programacionmovilprimeraapp.laboratorio6_pdm.data.repository

import android.util.Log
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.KtorClient
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.api.MealDto.MealDto
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.api.MealDto.toMeal
import com.programacionmovilprimeraapp.laboratorio6_pdm.data.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get

class MealRepositoryImpl: MealRepository{

    override suspend fun getRecetas(): Result<List<Meal>> {
        return try {
            val respuesta = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<MealDto>()

            val recetas = respuesta.meals.map { it.toMeal() }
            Result.success(recetas)
        } catch (e: Exception) {
            Log.e("MealRepo", "Error: ${e.message}", e)
            Result.failure(e)
        }
    }
}

