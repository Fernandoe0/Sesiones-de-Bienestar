package com.example.sesionesandroid.ui.screens.historial

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import com.example.sesionesandroid.data.remote.dto.CitaDto
import com.example.sesionesandroid.data.repository.CitaRepository

@Composable
fun HistorialScreen(nav: NavHostController) {
    Text("Historial")
    val ctx = LocalContext.current
    val repo = remember { CitaRepository(ctx) }
    var data by remember { mutableStateOf<List<CitaDto>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try { data = repo.listar() } catch (e: Exception) { error = "Error cargando historial" }
    }

    Column(Modifier.padding(16.dp)) {
        Text("Historial de Citas", style = MaterialTheme.typography.headlineSmall)
        if (error != null) Text(error!!, color = MaterialTheme.colorScheme.error)
        LazyColumn {
            items(data) { c ->
                Card (Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Column(Modifier.padding(12.dp)) {
                        Text("Fecha: ${c.fecha} Hora: ${c.hora}")
                        Text("Estado: ${c.estado}")
                        Text("Cliente: ${c.cliente.idCliente ?: "?"} Servicio: ${c.servicio.idServicio ?: "?"}")
                    }
                }
            }
        }
    }
}