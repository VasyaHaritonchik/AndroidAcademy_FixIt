package com.androidacademy.fixit.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.androidacademy.fixit.MainActivity
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    @LayoutRes
    protected open fun layoutRes(): Int = 0

    protected open fun title(): String = ""

    protected open fun initView() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.supportActionBar?.title = title()
        initView()
    }

    override fun showLoadingView(show: Boolean) {
        (activity as? MainActivity)?.showLoadingView(show)
    }
}