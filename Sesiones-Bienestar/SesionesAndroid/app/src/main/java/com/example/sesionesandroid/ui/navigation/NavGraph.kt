package com.example.sesionesandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sesionesandroid.ui.screens.cita.CitaFormScreen
import com.example.sesionesandroid.ui.screens.historial.HistorialScreen
import com.example.sesionesandroid.ui.screens.login.LoginScreen
import com.example.sesionesandroid.ui.screens.register.RegisterScreen
import com.example.sesionesandroid.ui.screens.servicios.ServiciosScreen

object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val SERVICIOS = "servicios"
    const val CITA_FORM = "cita_form"
    const val HISTORIAL = "historial"
}

@Composable
fun NavGraph(nav: NavHostController) {
    NavHost(navController = nav, startDestination = Routes.LOGIN){
        composable(Routes.LOGIN) { LoginScreen(nav) }
        composable(Routes.REGISTER) { RegisterScreen(nav) }
        composable(Routes.SERVICIOS) { ServiciosScreen(nav) }
        composable(Routes.CITA_FORM) { CitaFormScreen(nav) }
        composable(Routes.HISTORIAL) { HistorialScreen(nav) }
    }
}