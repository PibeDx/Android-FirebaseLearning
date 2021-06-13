package com.example.firebaselearning.data.datasource.remote.source

import com.google.firebase.messaging.FirebaseMessaging
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseRemoteDataSource(private val firebaseMessaging: FirebaseMessaging) {

    suspend fun getToken(): String = suspendCoroutine { continuation ->
        firebaseMessaging.token
            .addOnCompleteListener {
                continuation.resume(it.result!!)
            }
            .addOnCanceledListener {
                continuation.resumeWithException(throw NullPointerException())
            }
    }

}