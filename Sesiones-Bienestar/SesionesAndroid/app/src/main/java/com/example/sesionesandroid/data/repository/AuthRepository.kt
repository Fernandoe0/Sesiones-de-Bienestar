package com.example.sesionesandroid.data.repository

import android.content.Context
import com.example.sesionesandroid.data.local.Prefs
import com.example.sesionesandroid.data.remote.RetrofitClient
import com.example.sesionesandroid.data.remote.dto.LoginRequest
import com.example.sesionesandroid.data.remote.dto.RegisterRequest


class AuthRepository(context: Context) {
    private val api = RetrofitClient.create(context)
    private val prefs = Prefs(context)

    suspend fun login(username: String, password: String): Boolean {
        val res = api.login(LoginRequest(username, password))
        prefs.token = res.token
        return true
    }

    suspend fun register(username: String, password: String): Boolean {
        api.register(RegisterRequest(username, password))
        return true
    }

    fun logout() { prefs.token = null}
    fun isLoggedIn() = !prefs.token.isNullOrBlank()
}