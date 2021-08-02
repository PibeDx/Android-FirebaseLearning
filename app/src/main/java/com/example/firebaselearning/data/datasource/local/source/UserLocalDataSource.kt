package com.example.firebaselearning.data.datasource.local.source

import com.example.firebaselearning.data.datasource.local.preferences.UserPreferences
import com.example.firebaselearning.domain.model.Session
import com.google.gson.Gson
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val userPreferences: UserPreferences,
    private val gson: Gson
) {

    suspend fun saveSession(session: Session) {
        userPreferences.session = gson.toJson(session)
    }

    suspend fun hasSession(): Boolean = userPreferences.session.isNullOrBlank().not()

    suspend fun getSession(): Session {
        return gson.fromJson(userPreferences.session, Session::class.java)
    }

    suspend fun clearSession() {
        userPreferences.sharedPreferences.edit().clear().apply()
    }

}