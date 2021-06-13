package com.example.firebaselearning.presentation.feature.menu.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.firebaselearning.R
import com.example.firebaselearning.domain.usercase.GetTokenFirebase
import com.example.firebaselearning.presentation.di.MenuContainer
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MenuActivity : AppCompatActivity() {

    lateinit var getTokenFirebase: GetTokenFirebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        injectDependency()
    }

    private fun injectDependency() {
        getTokenFirebase = MenuContainer(baseContext).getTokenFirebase
    }

    override fun onResume() {
        super.onResume()

        GlobalScope.launch(Dispatchers.IO) {
            val token = getTokenFirebase()
            Log.i(TAG, "===> token: ${token}")
        }
    }

    companion object {
        private const val TAG = "MenuActivity"
    }
}