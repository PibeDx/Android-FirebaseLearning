package com.example.firebaselearning.presentation.di.core

import android.content.Context
import com.example.firebaselearning.domain.repository.AuthRepository
import com.example.firebaselearning.presentation.di.module.*
import com.example.firebaselearning.domain.repository.UserRepository
import com.example.firebaselearning.domain.repository.FirebaseRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    RepositoryModule::class,
    NetworkModule::class,
    FirebaseModule::class,
    UseCaseModule::class,
    UtilModule::class//,
])
interface AppComponent {

    fun context(): Context

    fun userRepository(): UserRepository

    fun firebaseRepository(): FirebaseRepository

    fun authRepository(): AuthRepository
}