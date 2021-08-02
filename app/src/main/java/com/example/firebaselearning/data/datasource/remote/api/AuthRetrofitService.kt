package com.example.firebaselearning.data.datasource.remote.api

import com.example.firebaselearning.domain.model.Session

interface AuthRetrofitService {

    fun logIn(username: String, password: String, token: String): Session
    fun logOut()

}