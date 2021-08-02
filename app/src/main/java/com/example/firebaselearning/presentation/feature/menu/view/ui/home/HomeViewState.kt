package com.example.firebaselearning.presentation.feature.menu.view.ui.home

sealed class HomeViewState {

    class ShowGreeting(val message: String) : HomeViewState()
}