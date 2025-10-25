package com.example.sesionesandroid.ui.screens.servicios

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sesionesandroid.data.remote.dto.ServicioDto
import com.example.sesionesandroid.data.repository.ServicioRepository
import androidx.compose.ui.platform.LocalContext
import com.example.sesionesandroid.ui.navigation.Routes

@Composable
fun ServiciosScreen(nav: NavHostController) {
    Text("Servicios")
    val ctx = LocalContext.current
    val repo = remember { ServicioRepository(ctx) }
    var data by remember { mutableStateOf<List<ServicioDto>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try { data = repo.listar() } catch (e: Exception) { error = "Error cargando servicios" }
        }

    Column(Modifier.padding(16.dp)) {
        Text("Servicios", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))
        if (error != null) Text(error!!, color = MaterialTheme.colorScheme.error)
        LazyColumn {
            items(data) { s ->
                Card(Modifier.fillMaxWidth().padding(vertical = 4.dp).clickable{
                    nav.navigate(Routes.CITA_FORM)
                }) {
                    Column(Modifier.padding(12.dp)) {
                        Text(s.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("Q ${s.precio}")
                    }
                }
        }
    }
        Spacer(Modifier.height(8.dp))
        Button(onClick = {nav.navigate(Routes.HISTORIAL)}) { Text("Ver historial de citas")}
    }
}