package com.example.laboratorio2_Grupo4


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio2_Grupo4.ui.theme.Laboratorio2Theme




    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                Laboratorio2Theme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        PantallaLista(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }

    @Composable
    fun PantallaLista(modifier: Modifier = Modifier) {
        val nombre: MutableState<String> = remember { mutableStateOf("") }
        val lista = remember { mutableStateListOf<String>()
    }
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = nombre.value,
                onValueChange = { nombre.value = it },
                label = { Text("Nombre") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))


        }
        Button(onClick = {
            if (nombre.value.isNotBlank()) {
                lista.add(nombre.value.trim())
                nombre.value = ""
            }
        }) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Listado de nombres y\nposicion en la lista",
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { lista.clear() }) {
                Text("Limpiar")
            }
        }
    }
