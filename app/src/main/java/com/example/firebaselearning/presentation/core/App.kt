package com.example.firebaselearning.presentation.core

import android.app.Application
import com.example.firebaselearning.presentation.di.core.AppComponent
import com.example.firebaselearning.presentation.di.core.DaggerAppComponent
import com.example.firebaselearning.presentation.di.module.AppModule

class App : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
}