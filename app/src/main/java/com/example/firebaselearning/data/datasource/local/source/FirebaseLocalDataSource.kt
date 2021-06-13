package com.example.firebaselearning.data.datasource.local.source

import com.example.firebaselearning.data.datasource.local.preferences.FirebasePreferences

class FirebaseLocalDataSource (private val firebasePreferences: FirebasePreferences) {

    fun saveTokenDevice(token: String) {
        firebasePreferences.tokenDevice = token
    }

    fun getTokenDevice(): String? = firebasePreferences.tokenDevice


    fun cleanDataFirebase() = firebasePreferences.sharedPreferences.edit().clear().apply()

}