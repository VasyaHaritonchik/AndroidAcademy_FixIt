package com.androidacademy.fixit


import android.os.Bundle
import android.app.Activity
import android.content.Intent

import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val RC_SIGN_IN = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Choose authentication providers
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()
            )

            // Create and launch sign-in intent
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
                RC_SIGN_IN)

//        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
//            .setAndroidPackageName(/* yourPackageName= */ ..., /* installIfNotAvailable= */ true,
//        /* minimumVersion= */ null)
//        .setHandleCodeInApp(true) // This must be set to true
//            .setUrl("https://google.com") // This URL needs to be whitelisted
//            .build();
//
//        startActivityForResult(
//            AuthUI.getInstance()
//                .createSignInIntentBuilder()
//                .setAvailableProviders(Arrays.asList(
//                    new AuthUI.IdpConfig.EmailBuilder().enableEmailLinkSignIn()
//                        .setActionCodeSettings(actionCodeSettings).build())
//                    .build(),
//                    RC_SIGN_IN);

//        if (AuthUI.canHandleIntent(intent)) {
//            if (intent.extras == null) {
//                return
//            }
//            val link = intent.extras!!.getString(ExtraConstants.EMAIL_LINK_SIGN_IN)
//            if (link != null) {
//                startActivityForResult(
//                    AuthUI.getInstance()
//                        .createSignInIntentBuilder()
//                        .setEmailLink(link)
//                        .setAvailableProviders(getAvailableProviders())
//                        .build(),
//                    RC_SIGN_IN
//                )
//            }
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }


}
