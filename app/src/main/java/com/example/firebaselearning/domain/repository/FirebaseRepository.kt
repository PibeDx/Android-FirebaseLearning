package com.example.firebaselearning.domain.repository

interface FirebaseRepository {

    suspend fun getToken(): String

}