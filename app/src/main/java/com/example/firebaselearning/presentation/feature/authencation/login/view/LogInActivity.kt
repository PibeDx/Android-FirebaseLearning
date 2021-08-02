package com.example.firebaselearning.presentation.feature.authencation.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.firebaselearning.databinding.ActivityLogInBinding
import com.example.firebaselearning.presentation.core.App
import com.example.firebaselearning.presentation.di.component.DaggerLoginComponent
import com.example.firebaselearning.presentation.di.core.AppComponent
import com.example.firebaselearning.presentation.feature.premenu.view.PreMenuActivity
import javax.inject.Inject

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        DaggerLoginComponent.builder()
            .appComponent(appComponent())
            .build()
            .inject(this)

        loginViewModel.viewState.observe(this, Observer { value ->
            when (value) {
                is LoginViewState.LogInSuccess -> goToPreMenu()
                is LoginViewState.LogInFailure -> showFailureLogIn()
                is LoginViewState.IsLogged -> goToPreMenu()
            }
        })
        loginViewModel.init()
    }

    private fun goToPreMenu() {
        startActivity(Intent(this, PreMenuActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }

    private fun showFailureLogIn() {
        val message = "The username or password is incorrect."
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        binding.buttonLogin.setOnClickListener {
            logIn()
        }
    }

    private fun logIn() {
        val username = binding.edittextUsername.text.toString()
        val password = binding.edittextPassword.text.toString()
        loginViewModel.logIn(username, password)
    }

    private fun appComponent(): AppComponent {
        return (application as App).appComponent
    }

    companion object {
        private const val TAG = "LogInActivity"
    }
}