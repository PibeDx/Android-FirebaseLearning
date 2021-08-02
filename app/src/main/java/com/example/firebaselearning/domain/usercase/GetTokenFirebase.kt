package com.example.firebaselearning.domain.usercase

import com.example.firebaselearning.domain.repository.FirebaseRepository
import javax.inject.Inject

class GetTokenFirebase @Inject constructor(private val firebaseRepository: FirebaseRepository) {

    suspend operator fun invoke(): String = firebaseRepository.getToken()

}