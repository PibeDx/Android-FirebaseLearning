package com.example.firebaselearning.data.datasource.local.preferences

import android.content.SharedPreferences

abstract class BasePreferences {

    companion object {
        const val FILE_NAME_ENCRYPTED_PREFERENCES = "encrypted_preferences"
        const val FILE_NAME_USER_PREFERENCES = "user_preferences"
        const val FILE_NAME_FIREBASE_PREFERENCES = "firebase_preferences"

        const val DEFAULT_INT_VALUE = -1
        const val DEFAULT_FLOAT_VALUE = -1f
        const val DEFAULT_LONG_VALUE = -1L
    }

    abstract val sharedPreferences: SharedPreferences

    private fun editor() = sharedPreferences.edit()

    fun getString(key: String): String? = sharedPreferences.getString(key, null)

    fun getInt(key: String): Int = sharedPreferences.getInt(key, DEFAULT_INT_VALUE)

    fun getFloat(key: String): Float = sharedPreferences.getFloat(key, DEFAULT_FLOAT_VALUE)

    fun getBoolean(key: String): Boolean = sharedPreferences.getBoolean(key, false)

    fun getLong(key: String): Long = sharedPreferences.getLong(key, DEFAULT_LONG_VALUE)

    fun putString(key: String, value: String) = editor().putString(key, value).apply()

    fun putInt(key: String, value: Int) = editor().putInt(key, value).apply()

    fun putFloat(key: String, value: Float) = editor().putFloat(key, value).apply()

    fun putBoolean(key: String, value: Boolean) = editor().putBoolean(key, value).apply()

    fun putLong(key: String, value: Long) = editor().putLong(key, value).apply()

}