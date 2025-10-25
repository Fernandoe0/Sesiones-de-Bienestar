package com.example.sesionesandroid.data.repository

import android.content.Context
import com.example.sesionesandroid.data.remote.RetrofitClient
import com.example.sesionesandroid.data.remote.dto.ServicioDto

class ServicioRepository(context: Context) {
    private val api = RetrofitClient.create(context)
    suspend fun listar(): List<ServicioDto> = api.getServicios()
}