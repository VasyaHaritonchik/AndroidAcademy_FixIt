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
    override fun title(): String = requireContext().getString(R.string.welcome)

    @Inject
    lateinit var auth: Auth

    override fun initView() {
        super.initView()
        App.instanse.appComponent.inject(this)
        login.setOnClickListener { auth.startAuth((requireActivity() as MainActivity)) }
    }


}
