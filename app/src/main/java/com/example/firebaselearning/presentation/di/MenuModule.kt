package com.example.firebaselearning.presentation.di

import android.content.Context
import com.example.firebaselearning.data.datasource.local.preferences.FirebasePreferences
import com.example.firebaselearning.data.datasource.local.source.FirebaseLocalDataSource
import com.example.firebaselearning.data.datasource.remote.source.FirebaseRemoteDataSource
import com.example.firebaselearning.data.repository.SessionRepositoryImpl
import com.example.firebaselearning.domain.usercase.GetTokenFirebase
import com.google.firebase.messaging.FirebaseMessaging


fun providerFirebaseMessaging() = FirebaseMessaging.getInstance()

fun providerFirebasePreferences(context: Context) = FirebasePreferences(context)

fun providerFirebaseLocalDataSource(context: Context) =
    FirebaseLocalDataSource(
        firebasePreferences = providerFirebasePreferences(context)
    )

fun providerFirebaseRemoteDataSource() = FirebaseRemoteDataSource(
    firebaseMessaging = providerFirebaseMessaging()
)

fun providerSessionRepository(context: Context) = SessionRepositoryImpl(
    firebaseLocalDataSource = providerFirebaseLocalDataSource(context),
    firebaseRemoteDataSource = providerFirebaseRemoteDataSource()
)

fun providerGetTokenFirebase(context: Context) = GetTokenFirebase(
    sessionRepository = providerSessionRepository(context)
)

class MenuContainer(context: Context) {
    val getTokenFirebase = providerGetTokenFirebase(context)
}