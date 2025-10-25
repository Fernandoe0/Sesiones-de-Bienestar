package com.example.sesionesandroid.data.remote.dto

data class CitaDto(
    val idCita: Long? = null,
    val fecha: String,
    val hora: String,
    val estado: String,
    val cliente: IdRef,
    val servicio: IdRef
)

data class IdRef(
    val idCliente: Long? = null,
    val idServicio: Long? = null
)

data class CitaAgendarRequest(
    val fecha: String,
    val hora: String,
    val estado: String,
    val clienteId: Long,
    val servicioId: Long
)