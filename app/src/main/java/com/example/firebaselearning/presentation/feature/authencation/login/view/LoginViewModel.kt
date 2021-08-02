package com.example.firebaselearning.presentation.feature.authencation.login.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaselearning.presentation.di.scope.PerActivity
import com.example.firebaselearning.domain.usercase.LogIn
import com.example.firebaselearning.domain.usercase.IsLogged
import kotlinx.coroutines.*
import javax.inject.Inject

@PerActivity
class LoginViewModel @Inject constructor(
    private val logIn: LogIn,
    private val isLogged: IsLogged
) : ViewModel() {

    private val _viewState = MutableLiveData<LoginViewState>()
    val viewState: LiveData<LoginViewState> = _viewState

    fun init() {
        isLogged()
    }

    private fun isLogged() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            _viewState.postValue(LoginViewState.LogInFailure)
        }
        viewModelScope.launch(exceptionHandler) {
            val isLogged = isLogged.invoke()
            if (isLogged) _viewState.postValue(LoginViewState.IsLogged)
        }
    }

    fun logIn(username: String, password: String) {

        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            _viewState.postValue(LoginViewState.LogInFailure)
        }
        viewModelScope.launch(exceptionHandler) {
            val session = logIn.invoke(username, password)
            _viewState.postValue(LoginViewState.LogInSuccess)
        }

    }

}