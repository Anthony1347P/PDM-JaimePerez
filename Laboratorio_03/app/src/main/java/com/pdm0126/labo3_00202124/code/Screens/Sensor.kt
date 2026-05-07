package com.pdm0126.labo3_00202124.code.Screens

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sensor(navigateBack: () -> Unit) {
    val lightValues = useSensor(Sensor.TYPE_LIGHT)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navigateBack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Volver al menu")
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Sensor de Luz Ambiental",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))

        if (lightValues.isNotEmpty()) {
            Text(
                text = "Intensidad: ${lightValues[0]} lx",
                fontSize = 18.sp
            )
        } else {
            Text(
                text = "Sensor no disponible en este dispositivo",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "JAIME ANTONIO PEREZ 00202124",
            fontSize = 14.sp
        )
    }
}

@Composable
fun useSensor(sensorType: Int): List<Float> {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val sensor = sensorManager.getDefaultSensor(sensorType) ?: return emptyList()
    var sensorValues by remember { mutableStateOf(listOf(0f, 0f, 0f)) }

    DisposableEffect(sensorType) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.values?.let {
                    sensorValues = it.toList()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    return sensorValues
}

