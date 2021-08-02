package com.example.firebaselearning.data.repository

import android.util.Log
import com.example.firebaselearning.data.datasource.local.source.FirebaseLocalDataSource
import com.example.firebaselearning.data.datasource.remote.source.FirebaseRemoteDataSource
import com.example.firebaselearning.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val firebaseRemoteDataSource: FirebaseRemoteDataSource,
    private val firebaseLocalDataSource: FirebaseLocalDataSource
) : FirebaseRepository {

    override suspend fun getToken(): String {
        val tokenDeviceLocal = firebaseLocalDataSource.getTokenDevice()
        return if (tokenDeviceLocal == null) {
            val token = firebaseRemoteDataSource.getToken()
            Log.d(TAG, "get token device online")
            firebaseLocalDataSource.saveTokenDevice(token)
            Log.d(TAG, "save token device")
            token
        } else {
            Log.d(TAG, "get token device offline")
            firebaseLocalDataSource.getTokenDevice()
                ?: throw IllegalAccessException("This user no saved token")
        }
    }

    companion object {
        const val TAG = "SessionRepositoryImpl"
    }
}