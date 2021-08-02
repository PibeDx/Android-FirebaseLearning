package com.example.firebaselearning.domain.usercase

import com.example.firebaselearning.domain.repository.AuthRepository

class LogOut constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke() {
        authRepository.logOut()
        authRepository.cleanSession()
    }

}