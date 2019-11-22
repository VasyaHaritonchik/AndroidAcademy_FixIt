package com.androidacademy.fixit.core.di

import com.androidacademy.fixit.core.network.NetworkModule
import com.androidacademy.fixit.utils.Auth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @get:Provides @Singleton val networkModule: NetworkModule by lazy { NetworkModule() }
    @get:Provides @Singleton val auth: Auth by lazy { Auth() }
}