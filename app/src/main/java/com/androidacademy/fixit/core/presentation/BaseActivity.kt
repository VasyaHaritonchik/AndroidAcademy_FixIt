package com.androidacademy.fixit.core.presentation

import android.os.Bundle
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    protected val app = App()

    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()
    }
}
