package com.example.sesionesandroid.domain.models

data class Cita(
    val idCita: Long? = null,
    val fecha: String = "",
    val hora: String = "",
    val estado: String = "",
    val clienteId: Long? = null,
    val servicioId: Long? = null
)
