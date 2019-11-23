package com.androidacademy.fixit.core.presentation

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {
    fun showLoadingView(show: Boolean)
}