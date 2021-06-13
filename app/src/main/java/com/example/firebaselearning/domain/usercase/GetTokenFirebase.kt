package com.example.firebaselearning.domain.usercase

import com.example.firebaselearning.domain.repository.SessionRepository

class GetTokenFirebase(private val sessionRepository: SessionRepository) {

    suspend operator fun invoke(): String = sessionRepository.getToken()

}