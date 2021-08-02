package com.example.firebaselearning.presentation.feature.menu.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaselearning.domain.usercase.GetSession
import com.example.firebaselearning.presentation.di.scope.PerActivity
import com.example.firebaselearning.presentation.di.scope.PerFragment
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@PerFragment
class HomeViewModel @Inject constructor(
    private val getSession: GetSession
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState> = _viewState

    fun getGreeting() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        viewModelScope.launch(exceptionHandler) {
            val session = getSession()
            val message = "Hello ${session.name}!"
            _viewState.postValue(HomeViewState.ShowGreeting(message))
        }
    }
}