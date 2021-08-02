package com.example.firebaselearning.presentation.feature.menu.view

sealed class MenuViewState {

    class GetTokenSuccess(val token: String) : MenuViewState()

}