package com.example.firebaselearning.presentation.feature.main.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val viewState: LiveData<MainViewState> get() = _viewState
    private val _viewState = MutableLiveData<MainViewState>()

    init {
        GlobalScope.launch {
            delay(3000)
            _viewState.postValue(MainViewState.GoToLogIn)
        }
    }

}