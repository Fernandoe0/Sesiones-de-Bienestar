package com.example.sesionesandroid.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class Prefs(context: Context) {
    private val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val sp = EncryptedSharedPreferences.create(
        "secure_prefs", masterKey, context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    var token: String?
        get() = sp.getString("jwt", null)
        set(value) = sp.edit().putString("jwt", value).apply()
}