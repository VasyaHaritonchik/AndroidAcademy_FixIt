package com.androidacademy.fixit.core.di

import com.androidacademy.fixit.MainActivity
import com.androidacademy.fixit.core.presentation.login.view.LoginFragment
import com.androidacademy.fixit.core.presentation.neworder.view.UserChoiceFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: UserChoiceFragment)
}