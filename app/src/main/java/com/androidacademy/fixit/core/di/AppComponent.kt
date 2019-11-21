package com.androidacademy.fixit.core.di

import com.androidacademy.fixit.core.presentation.BaseActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: BaseActivity)
}