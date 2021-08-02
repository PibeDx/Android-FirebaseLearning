package com.example.firebaselearning.data.datasource.remote.source

import com.example.firebaselearning.data.datasource.remote.api.AuthRetrofitService
import com.example.firebaselearning.domain.model.Session
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authRetrofitService: AuthRetrofitService
) {

    suspend fun logIn(username: String, password: String, token: String): Session {
        return authRetrofitService.logIn(username, password, token)
    }

    suspend fun logOut() {
        authRetrofitService.logOut()
    }

}