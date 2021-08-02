package com.example.firebaselearning.presentation.di.module

import com.example.firebaselearning.data.repository.AuthRepositoryImpl
import com.example.firebaselearning.data.repository.FirebaseRepositoryImpl
import com.example.firebaselearning.data.repository.UserRepositoryImpl
import com.example.firebaselearning.domain.repository.AuthRepository
import com.example.firebaselearning.domain.repository.UserRepository
import com.example.firebaselearning.domain.repository.FirebaseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideSessionRepository(sessionRepositoryImpl: FirebaseRepositoryImpl): FirebaseRepository {
        return sessionRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository {
        return authRepositoryImpl
    }


}