package com.androidacademy.fixit.core.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidacademy.fixit.R

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.empty)
        if (supportFragmentManager.findFragmentByTag(FRAGMENT_SERVICE_LIST) == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    android.R.id.content,
                    ServiceListFragment.getInstance(), FRAGMENT_SERVICE_LIST
                )
                .commit()
        }
    }

    companion object {
        private const val FRAGMENT_SERVICE_LIST = "FRAGMENT_SERVICE_LIST_SPACE"
    }
}
