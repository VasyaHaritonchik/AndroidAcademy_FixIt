package com.androidacademy.fixit.core.presentation.login.view

import com.androidacademy.fixit.MainActivity
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.utils.Auth
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment: BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_login
    override fun title(): Int = R.string.welcome

    @Inject
    lateinit var auth: Auth

    override fun inject() {
        App.instanse.appComponent.inject(this)
    }

    override fun initView() {
        super.initView()
        login.setOnClickListener { auth.startAuth((requireActivity() as MainActivity)) }
    }


}
