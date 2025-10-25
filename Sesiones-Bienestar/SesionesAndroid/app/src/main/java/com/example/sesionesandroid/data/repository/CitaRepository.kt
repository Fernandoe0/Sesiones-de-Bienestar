package com.example.sesionesandroid.data.repository

import android.content.Context
import com.example.sesionesandroid.data.remote.RetrofitClient
import com.example.sesionesandroid.data.remote.dto.CitaDto
import com.example.sesionesandroid.data.remote.dto.IdRef

class CitaRepository(context: Context) {
    private val api = RetrofitClient.create(context)

    suspend fun listar(): List<CitaDto> = api.getCitas()

    suspend fun agendar(fecha: String, hora: String, estado: String, clienteId: Long, servicioId: Long) {
        val cita = CitaDto(
            fecha = fecha, hora = hora, estado = estado,
            cliente = IdRef(idCliente = clienteId),
            servicio = IdRef(idServicio = servicioId)
        )
        api.agendarCita(cita)
    }

    suspend fun cancelar(id: Long) {
        api.cancelarCita(id)
    }
}