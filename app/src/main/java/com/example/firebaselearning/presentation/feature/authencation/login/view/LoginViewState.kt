package com.example.firebaselearning.presentation.feature.authencation.login.view

sealed class LoginViewState {

    object LogInSuccess : LoginViewState()
    object LogInFailure : LoginViewState()

    object IsLogged : LoginViewState()

}