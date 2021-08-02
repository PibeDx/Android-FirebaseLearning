package com.example.firebaselearning.presentation.feature.menu.view

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaselearning.presentation.di.scope.PerActivity
import com.example.firebaselearning.domain.usercase.GetTokenFirebase
import kotlinx.coroutines.*
import javax.inject.Inject

@PerActivity
class MenuViewModel @Inject constructor(
    private val getTokenFirebase: GetTokenFirebase,
    private val context: Context
) : ViewModel() {

    private val _viewState = MutableLiveData<MenuViewState>()
    val viewState: LiveData<MenuViewState> = _viewState

    fun getToken() {
        /*
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        viewModelScope.launch(exceptionHandler) {
            val token = getTokenFirebase()
            _viewState.postValue(MenuViewState.GetTokenSuccess(token))
        }
        */
        GlobalScope.launch(Dispatchers.IO) {
            val token = getTokenFirebase()
            _viewState.postValue(MenuViewState.GetTokenSuccess(token))
        }
    }

    companion object {
        const val TAG = "MenuViewModel"
    }

}