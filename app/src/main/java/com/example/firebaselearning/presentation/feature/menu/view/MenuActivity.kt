package com.example.firebaselearning.presentation.feature.menu.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.firebaselearning.R
import com.example.firebaselearning.presentation.core.App
import com.example.firebaselearning.presentation.di.component.DaggerMenuComponent
import com.example.firebaselearning.presentation.di.core.AppComponent
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MenuActivity : AppCompatActivity() {

    /*
    val applicationGraph: AppComponent = DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()
    val userDataRepository1: UserRepository = applicationGraph.userRepository()
    val userDataRepository2: UserRepository = applicationGraph.userRepository()
    */

    @Inject
    lateinit var menuViewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMenuComponent.builder()
            .appComponent(appComponent())
            .build()
            .inject(this)
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

        menuViewModel.viewState.observe(this, Observer<MenuViewState> { value ->
            when (value) {
                is MenuViewState.GetTokenSuccess -> Log.i(TAG, "===> token: ${value.token}")
            }
        })
    }

    private fun appComponent(): AppComponent {
        return (application as App).appComponent
    }

    override fun onResume() {
        super.onResume()
        menuViewModel.getToken()
    }

    companion object {
        private const val TAG = "MenuActivity"
    }
}