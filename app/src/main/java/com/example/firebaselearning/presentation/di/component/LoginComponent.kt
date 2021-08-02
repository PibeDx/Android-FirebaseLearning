package com.example.firebaselearning.presentation.di.component

import com.example.firebaselearning.presentation.di.core.AppComponent
import com.example.firebaselearning.presentation.di.scope.PerActivity
import com.example.firebaselearning.presentation.feature.authencation.login.view.LogInActivity
import dagger.Component


@PerActivity
@Component(dependencies = [AppComponent::class])
interface LoginComponent {

    fun inject(logInActivity: LogInActivity)

}