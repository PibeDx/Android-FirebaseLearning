package com.example.firebaselearning.presentation.di.module

import com.example.firebaselearning.domain.repository.AuthRepository
import com.example.firebaselearning.domain.repository.UserRepository
import com.example.firebaselearning.domain.repository.FirebaseRepository
import com.example.firebaselearning.domain.usercase.GetSession
import com.example.firebaselearning.domain.usercase.GetTokenFirebase
import com.example.firebaselearning.domain.usercase.LogIn
import com.example.firebaselearning.domain.usercase.IsLogged
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetTokenFirebase(firebaseRepository: FirebaseRepository): GetTokenFirebase {
        return GetTokenFirebase(firebaseRepository)
    }

    @Provides
    @Singleton
    fun provideLogIn(authRepository: AuthRepository, firebaseRepository: FirebaseRepository): LogIn {
        return LogIn(authRepository, firebaseRepository)
    }

    @Provides
    @Singleton
    fun provideIsLogged(userRepository: UserRepository): IsLogged {
        return IsLogged(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetSession(userRepository: UserRepository): GetSession {
        return GetSession(userRepository)
    }

}