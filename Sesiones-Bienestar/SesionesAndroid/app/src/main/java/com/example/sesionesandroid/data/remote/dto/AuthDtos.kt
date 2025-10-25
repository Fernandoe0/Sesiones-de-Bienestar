package com.example.sesionesandroid.data.remote.dto

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String)

data class RegisterRequest(val username: String, val password: String, val rol: String = "USER")
