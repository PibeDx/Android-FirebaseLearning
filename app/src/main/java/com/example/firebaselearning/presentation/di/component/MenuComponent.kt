package com.example.firebaselearning.presentation.di.component

import com.example.firebaselearning.presentation.di.core.AppComponent
import com.example.firebaselearning.presentation.di.scope.PerActivity
import com.example.firebaselearning.presentation.feature.menu.view.MenuActivity
import dagger.Component


@PerActivity
@Component(dependencies = [AppComponent::class])
interface MenuComponent {

    fun inject(menuActivity: MenuActivity)

}