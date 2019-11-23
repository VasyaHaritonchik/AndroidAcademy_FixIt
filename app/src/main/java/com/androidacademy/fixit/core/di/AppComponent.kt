package com.androidacademy.fixit.core.di

import com.androidacademy.fixit.MainActivity
import com.androidacademy.fixit.core.presentation.address.AddressFragment
import com.androidacademy.fixit.core.presentation.login.view.LoginFragment
import com.androidacademy.fixit.core.presentation.servicesList.ServiceListFragment
import com.androidacademy.fixit.core.presentation.targetsList.TargetListFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ServiceListFragment)
    fun inject(fragment: TargetListFragment)
    fun inject(fragment: AddressFragment)
}