package com.example.sesionesandroid.data.remote

import com.example.sesionesandroid.data.remote.dto.*
import retrofit2.http.*
interface ApiService {
    //Auth
    @POST("auth/login")
    suspend fun login(@Body req: LoginRequest): LoginResponse

    @POST("usuarios")
    suspend fun register(@Body req: RegisterRequest): Any

    //Servicios
    @GET("servicios")
    suspend fun getServicios(): List<ServicioDto>

    @POST("servicios")
    suspend fun createServicio(@Body s: ServicioDto): ServicioDto

    //Citas
    @GET("citas")
    suspend fun getCitas(): List<CitaDto>

    @POST("citas")
    suspend fun agendarCita(@Body cita: CitaDto): Any

    @DELETE("citas/{id}")
    suspend fun cancelarCita(@Path("id") id: Long): Any
}