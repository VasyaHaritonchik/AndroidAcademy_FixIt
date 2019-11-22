package com.androidacademy.fixit.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.androidacademy.fixit.MainActivity

abstract class BaseFragment : Fragment() {

    @LayoutRes
    protected open fun layoutRes(): Int = 0

    protected open fun title(): String = ""

    protected open fun initView() {}

    protected open fun inject() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.supportActionBar?.title = title()
        initView()
    }
}