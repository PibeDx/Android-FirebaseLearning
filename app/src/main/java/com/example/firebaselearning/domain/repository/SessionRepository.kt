package com.example.firebaselearning.domain.repository

interface SessionRepository {

    suspend fun getToken(): String

}