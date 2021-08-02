package com.example.firebaselearning.data.repository

import com.example.firebaselearning.data.datasource.local.source.UserLocalDataSource
import com.example.firebaselearning.data.datasource.remote.source.AuthRemoteDataSource
import com.example.firebaselearning.domain.model.Session
import com.example.firebaselearning.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {

    override suspend fun logIn(username: String, password: String, token: String): Session {
        val session = authRemoteDataSource.logIn(username, password, token)
        userLocalDataSource.saveSession(session)
        return session
    }

    override suspend fun logOut() {
        cleanSession()
        authRemoteDataSource.logOut()
    }

    override suspend fun cleanSession() {
        userLocalDataSource.clearSession()
    }
}