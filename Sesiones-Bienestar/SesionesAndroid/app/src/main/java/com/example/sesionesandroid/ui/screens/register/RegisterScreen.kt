package com.example.sesionesandroid.ui.screens.register

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sesionesandroid.data.repository.AuthRepository
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(nav: NavHostController) {
    val ctx = LocalContext.current
    val repo = remember { AuthRepository(ctx) }
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var info by remember { mutableStateOf<String?>(null) }

    Column(Modifier.padding(16.dp)) {
        Text("Registro", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(value = user, onValueChange = { user = it }, label = { Text("Usuario") })
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = pass, onValueChange = { pass = it }, label = { Text("Contraseña") })
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            if (user.length < 3) { info = "Usuario mínimo 3 caracteres"; return@Button }
            if (pass.length < 4) { info = "Contraseña mínima 4"; return@Button }
            info = null
            //Registro básico:
            kotlinx.coroutines.GlobalScope.launch {
                try {
                    repo.register(user, pass)
                    info = "Usuario creado. Inicia sesión."
                } catch (e: Exception) { info = "Error registrando: ${e.message}"}
            }
        }) { Text("Crear cuenta")}
        info?.let { Text(it)}
    }
}