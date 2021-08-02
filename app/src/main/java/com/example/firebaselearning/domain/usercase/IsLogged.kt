package com.example.firebaselearning.domain.usercase

import com.example.firebaselearning.domain.repository.UserRepository
import javax.inject.Inject

class IsLogged @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke() = userRepository.hasSession()

}