package com.example.firebaselearning.data.datasource.local.source

import com.example.firebaselearning.data.datasource.local.preferences.FirebasePreferences
import javax.inject.Inject

class FirebaseLocalDataSource @Inject constructor(private val firebasePreferences: FirebasePreferences) {

    suspend fun saveTokenDevice(token: String) {
        firebasePreferences.tokenDevice = token
    }

    suspend fun getTokenDevice(): String? = firebasePreferences.tokenDevice


    suspend fun cleanDataFirebase() = firebasePreferences.sharedPreferences.edit().clear().apply()

}