package com.example.firebaselearning.data.datasource.remote.api

import com.example.firebaselearning.domain.model.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRetrofitServiceImpl @Inject constructor() : AuthRetrofitService {

    override fun logIn(username: String, password: String, token: String): Session {
        return getAuths().find {
            it.username.equals(username, ignoreCase = true) &&
            it.password.equals(password, ignoreCase = true)
        }?.let {
            it.session
        } ?: throw Exception()
    }

    override fun logOut() {
        //TODO: consume api logout
    }

    fun getAuths(): List<Auth> {
        return listOf(
            Auth(
                username = "pibedx",
                password = "pibedx",
                session = Session(
                    token = "tokenxyz",
                    name = "José",
                    lastName = "Cuentas"
                )
            )
        )
    }

    data class Auth(val username: String, val password: String, val session: Session)
}