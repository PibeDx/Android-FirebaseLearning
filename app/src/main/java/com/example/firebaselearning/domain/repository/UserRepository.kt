package com.example.firebaselearning.domain.repository

import com.example.firebaselearning.domain.model.Session


interface UserRepository {

    suspend fun hasSession(): Boolean

    suspend fun getSession(): Session

}