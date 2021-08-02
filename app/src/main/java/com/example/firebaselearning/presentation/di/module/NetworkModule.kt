package com.example.firebaselearning.presentation.di.module

import com.example.firebaselearning.data.datasource.remote.api.AuthRetrofitService
import com.example.firebaselearning.data.datasource.remote.api.AuthRetrofitServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoginRetrofitService(loginRetrofitServiceImpl: AuthRetrofitServiceImpl): AuthRetrofitService {
        return loginRetrofitServiceImpl
    }

}