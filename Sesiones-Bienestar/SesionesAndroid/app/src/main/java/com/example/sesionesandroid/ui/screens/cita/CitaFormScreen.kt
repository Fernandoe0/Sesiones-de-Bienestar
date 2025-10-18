package com.example.sesionesandroid.ui.screens.cita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import com.example.sesionesandroid.data.repository.CitaRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitaFormScreen(nav: NavHostController) {
    Text("Formulario Cita")
    val scope = rememberCoroutineScope()
   val ctx = LocalContext.current
    val repo = remember { CitaRepository(ctx) }

    var fecha by rememberSaveable { mutableStateOf("") }
    var hora by rememberSaveable { mutableStateOf("") }
    var clienteId by rememberSaveable { mutableStateOf("") }
    var servicioId by rememberSaveable { mutableStateOf("") }
    var info by rememberSaveable { mutableStateOf<String?>(null) }
    var cancelarId by rememberSaveable { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("Agendar Cita", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(fecha, { fecha = it}, label = { Text("Fecha (YYYY-MM-DD)") })
        OutlinedTextField(hora, {hora = it}, label = { Text("Hora (HH:MM)") })
        OutlinedTextField(clienteId, { clienteId = it}, label = { Text("Cliente ID") })
        OutlinedTextField(servicioId, { servicioId = it}, label = { Text("Servicio ID") })
        Spacer(Modifier.height(8.dp))

        Button(onClick = {
          if (fecha.isBlank() || hora.isBlank() || clienteId.isBlank() || servicioId.isBlank()) {
              info = "Todos los campos son obligatorios"; return@Button
          }
            val cId = clienteId.toLongOrNull()
            val sId = servicioId.toLongOrNull()
            if (cId == null || sId == null) {info = "IDs inválidos"; return@Button }
            info = null
            scope.launch {
                try {
                    repo.agendar(fecha, hora, "Vigente", cId, sId)
                    info = "Cita agendada ✅"
                } catch (e: Exception) {
                    info = "Error agendando: ${e.message}"
                }
            }
        }) { Text("Agendar")}

        Spacer(Modifier.height(16.dp))
        Divider()
        Spacer(Modifier.height(8.dp))

        Text("Cancelar Cita", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = cancelarId, onValueChange =  { cancelarId = it },
            label = { Text("ID Cita") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val id = cancelarId.toLongOrNull()
            if (id == null) { info = "Id de cita inválido"; return@Button}
            scope.launch {
                try {
                    repo.cancelar(id)
                    info = "Cita cancelada ❌"
                } catch (e: Exception) {
                    info = "Error cancelando: ${e.message}"
                }
            }
        }) { Text("Cancelar")}

        info?.let { Text(it) }
    }
}