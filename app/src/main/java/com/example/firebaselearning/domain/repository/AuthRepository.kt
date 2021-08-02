package com.example.firebaselearning.domain.repository

import com.example.firebaselearning.domain.model.Session

interface AuthRepository {

    suspend fun logIn(username: String, password: String, token: String): Session

    suspend fun logOut()

    suspend fun cleanSession()

}