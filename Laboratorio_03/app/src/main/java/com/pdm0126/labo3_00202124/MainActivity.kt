package com.pdm0126.labo3_00202124

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdm0126.labo3_00202124.code.Navigation.App
import com.pdm0126.labo3_00202124.ui.theme.LABORATORIO3_00202124Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LABORATORIO3_00202124Theme {
                App()
            }
        }
    }
}