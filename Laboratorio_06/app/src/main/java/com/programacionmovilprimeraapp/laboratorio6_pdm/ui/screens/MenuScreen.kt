package com.programacionmovilprimeraapp.laboratorio6_pdm.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.programacionmovilprimeraapp.laboratorio6_pdm.viewmodel.MealViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun MealScreen(
    viewModel: MealViewModel = viewModel()
) {
    val recetas  by viewModel.recetas.collectAsStateWithLifecycle()
    val cargando by viewModel.cargando.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) { viewModel.cargarRecetas() }

    if (cargando) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn {
            items(recetas) { receta ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    AsyncImage(
                        model = receta.imagenUrl,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Text(receta.nombre, style = MaterialTheme.typography.titleSmall)
                    }
                }
            }
        }
    }
}