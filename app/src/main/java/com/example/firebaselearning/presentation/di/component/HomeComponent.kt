package com.example.firebaselearning.presentation.di.component

import com.example.firebaselearning.presentation.di.core.AppComponent
import com.example.firebaselearning.presentation.di.scope.PerFragment
import com.example.firebaselearning.presentation.feature.menu.view.ui.home.HomeFragment
import dagger.Component


@PerFragment
@Component(dependencies = [AppComponent::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

}