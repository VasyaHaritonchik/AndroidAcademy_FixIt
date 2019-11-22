package com.androidacademy.fixit.core

import android.app.Application
import com.androidacademy.fixit.core.di.AppComponent
import com.androidacademy.fixit.core.di.AppModule
import com.androidacademy.fixit.core.di.DaggerAppComponent

class App: Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    fun getComponent(): AppComponent {
        if (!::component.isInitialized) component = DaggerAppComponent.builder().appModule(AppModule()).build()
        return component
    }
}