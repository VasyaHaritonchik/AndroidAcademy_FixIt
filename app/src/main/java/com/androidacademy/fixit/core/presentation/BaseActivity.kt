package com.androidacademy.fixit.core.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App
import com.androidacademy.fixit.core.di.AppComponent
import com.androidacademy.fixit.core.network.NetworkModule
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    private val app = App()
    
    abstract fun inject(component: AppComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        inject(app.getComponent())
    }
}
