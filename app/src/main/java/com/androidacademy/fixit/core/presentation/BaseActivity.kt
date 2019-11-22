package com.androidacademy.fixit.core.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App

abstract class BaseActivity : AppCompatActivity() {

    protected val app = App()

    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()
    }

    override fun onResume() {
        super.onResume()
    }
}
