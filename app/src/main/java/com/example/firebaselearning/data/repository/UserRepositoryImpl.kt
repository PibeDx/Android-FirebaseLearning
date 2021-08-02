package com.example.firebaselearning.data.repository

import com.example.firebaselearning.data.datasource.local.source.UserLocalDataSource
import com.example.firebaselearning.domain.repository.UserRepository
import com.example.firebaselearning.domain.model.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val localDataSource: UserLocalDataSource
) : UserRepository {

    override suspend fun hasSession(): Boolean = localDataSource.hasSession()

    override suspend fun getSession(): Session = localDataSource.getSession()

}