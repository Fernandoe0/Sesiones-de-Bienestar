package com.example.sesionesandroid.data.remote

import com.example.sesionesandroid.data.local.Prefs
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val prefs: Prefs): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = prefs.token
        val req = if (!token.isNullOrBlank()) {
            chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        } else chain.request()
        return chain.proceed(req)
    }
}