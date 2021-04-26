package com.example.firebaselearning.presentation.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.firebaselearning.R
import com.example.firebaselearning.presentation.feature.authencation.login.view.LogInActivity
import com.example.firebaselearning.presentation.feature.main.view.MainViewModel
import com.example.firebaselearning.presentation.feature.main.view.MainViewState
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAnalytics = Firebase.analytics

        viewModel.viewState.observe(this, Observer {
            when(it) {
                is MainViewState.GoToLogIn -> goToLogIn()
            }
        })
    }

    private fun goToLogIn() {
        startActivity(Intent(this, LogInActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }

    override fun onResume() {
        super.onResume()
    }
}