package com.example.firebaselearning.domain.usercase

import com.example.firebaselearning.domain.repository.AuthRepository
import com.example.firebaselearning.domain.repository.FirebaseRepository
import javax.inject.Inject

class LogIn @Inject constructor(
    private val authRepository: AuthRepository,
    private val firebaseRepository: FirebaseRepository
){

    suspend operator fun invoke(username: String, password: String) {
        val token = firebaseRepository.getToken()
        authRepository.logIn(username, password, token)
    }

}