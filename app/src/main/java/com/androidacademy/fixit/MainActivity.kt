package com.androidacademy.fixit


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.androidacademy.fixit.core.App
import com.androidacademy.fixit.core.presentation.BaseActivity
import com.androidacademy.fixit.core.presentation.login.view.LoginFragment
import com.androidacademy.fixit.core.presentation.neworder.view.UserChoiceFragment
import com.androidacademy.fixit.utils.Auth
import com.androidacademy.fixit.utils.Auth.Companion.RC_SIGN_IN
import com.androidacademy.fixit.utils.navigation.NavigationUtils.openFragment
import com.androidacademy.fixit.utils.visibility
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var auth: Auth

    private var isLogged: Boolean = false

    override fun inject() {
        App.instanse.appComponent.inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        (toolbar as? Toolbar)?.let { setSupportActionBar(it) }
        if (supportFragmentManager.fragments.isNullOrEmpty()) auth.checkAuth { openFragment(it) }
    }

    private fun openFragment(login: Boolean) {
        if (!login) openFragment(
            LoginFragment(),
            supportFragmentManager,
            fragment_container.id,
            LOGIN_FRAGMENT,
            false
        )
        else openFragment(
            UserChoiceFragment(),
            supportFragmentManager,
            fragment_container.id,
            CREATE_NEW_ORDER_FRAGMENT,
            false
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                val user = FirebaseAuth.getInstance().currentUser
                isLogged = true
            }
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        if (isLogged) {
            isLogged = false
            openFragment(
                UserChoiceFragment(),
                supportFragmentManager,
                fragment_container.id,
                CREATE_NEW_ORDER_FRAGMENT,
                false
            )

        }

    }

    fun showLoadingView(show: Boolean) {
        hide_view.visibility(show)
        progress.visibility(show)
    }

    companion object {
        const val LOGIN_FRAGMENT = "login_fragment"
        const val CREATE_NEW_ORDER_FRAGMENT = "create_order_fragment"
    }
}
