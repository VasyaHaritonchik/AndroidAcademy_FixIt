package com.androidacademy.fixit.core.network

import com.androidacademy.fixit.utils.ConstApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




class NetworkModule {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(ConstApi.Main.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> getApiService(apiClass: Class<T>): T = retrofit.create(apiClass)

}