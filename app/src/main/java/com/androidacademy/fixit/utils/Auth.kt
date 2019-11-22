package com.androidacademy.fixit.utils

import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.presentation.BaseActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class Auth {
    private val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.PhoneBuilder().build()
    )

    fun checkAuth(action: (Boolean) -> Unit) {
        action.invoke(FirebaseAuth.getInstance().currentUser != null)
    }

    fun startAuth(activity: BaseActivity) {
        activity.startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setTheme(R.style.LoginTheme)
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )
    }

    companion object {
        const val RC_SIGN_IN = 100
    }
}