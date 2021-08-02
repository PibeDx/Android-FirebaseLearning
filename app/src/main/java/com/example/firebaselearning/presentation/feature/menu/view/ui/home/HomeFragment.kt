package com.example.firebaselearning.presentation.feature.menu.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.firebaselearning.R
import com.example.firebaselearning.presentation.core.App
import com.example.firebaselearning.presentation.di.component.DaggerHomeComponent
import com.example.firebaselearning.presentation.di.core.AppComponent
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerHomeComponent.builder()
            .appComponent(appComponent())
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)

        homeViewModel.viewState.observe(viewLifecycleOwner, Observer { value ->
            when (value) {
                is HomeViewState.ShowGreeting -> textView.text = value.message
            }
        })


        return root
    }

    private fun appComponent(): AppComponent {
        return (activity?.application as App).appComponent
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getGreeting()

        Firebase.analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "HomeFragment")
        }
    }
}