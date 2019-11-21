package com.androidacademy.fixit.core.di

import com.androidacademy.fixit.core.network.NetworkModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @get:Provides @Singleton val networkModule: NetworkModule by lazy { NetworkModule() }
}