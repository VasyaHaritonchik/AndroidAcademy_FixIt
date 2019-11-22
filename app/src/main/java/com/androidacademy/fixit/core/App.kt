package com.androidacademy.fixit.core

import android.app.Application
import com.androidacademy.fixit.core.di.AppComponent
import com.androidacademy.fixit.core.di.AppModule
import com.androidacademy.fixit.core.di.DaggerAppComponent

class App : Application() {


    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    init {
        instanse = this
    }


    companion object {
        lateinit var instanse: App
    }
}