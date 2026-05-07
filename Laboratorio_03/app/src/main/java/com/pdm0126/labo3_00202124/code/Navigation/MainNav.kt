package com.pdm0126.labo3_00202124.code.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdm0126.labo3_00202124.code.Screens.MainMenu
import com.pdm0126.labo3_00202124.code.Screens.NamesList
import com.pdm0126.labo3_00202124.code.Screens.Sensor

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainMenuScreen
    ) {
        composable<MainMenuScreen> {
            MainMenu(
                navigateToNameList = { navController.navigate(NamesListScreen) },
                navigateToSensor   = { navController.navigate(SensorScreen) }
            )
        }
        composable<NamesListScreen> {
            NamesList(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable<SensorScreen> {
            Sensor(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}