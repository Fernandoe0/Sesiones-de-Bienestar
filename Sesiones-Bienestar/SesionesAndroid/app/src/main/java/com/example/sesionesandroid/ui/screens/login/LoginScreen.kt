package com.example.sesionesandroid.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.util.VelocityTrackerAddPointsFix
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sesionesandroid.ui.navigation.Routes
import kotlinx.coroutines.launch
import com.example.sesionesandroid.data.repository.AuthRepository
import androidx.compose.ui.platform.LocalContext

@Composable
fun LoginScreen(nav: NavHostController) {
    Text("Login")
    val ctx = LocalContext.current
    val repo = remember { AuthRepository(ctx) }
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope ()

    Column(Modifier.padding(16.dp)) {
        Text("Login", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(value = user, onValueChange = { user = it }, label = { Text("Usuario")})
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = pass, onValueChange = { pass = it}, label = { Text("Contraseña")})
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            error = null
            if (user.isBlank() || pass.isBlank()) {
                error = "Usuario y contraseña requeridos"; return@Button
            }
            scope.launch {
                try {
                    val ok = repo.login(user, pass)
                    if (ok) nav.navigate(Routes.SERVICIOS) {
                        popUpTo(Routes.LOGIN) {
                            inclusive = true
                        }
                    }
                } catch (e: Exception) {
                    error = "Credenciales inválidas"
                }
            }
        }) { Text("Entrar")}
        TextButton(onClick = { nav.navigate(Routes.REGISTER)}) { Text("¿No tienes cuenta? Regístrate") }
        error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
    }
}