package com.example.sesionesandroid.data.remote

import android.content.Context
import com.example.sesionesandroid.data.local.Prefs
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitClient {
    fun create(context: Context): ApiService {
        val prefs = Prefs(context)
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(prefs))
            .addInterceptor(logger)
            .build()

        val moshi = Moshi.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(System.getenv("VITE_API_URL") ?: "http://10.0.2.2:8080/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}