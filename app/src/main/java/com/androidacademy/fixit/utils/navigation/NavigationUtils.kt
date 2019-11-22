package com.androidacademy.fixit.utils.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.androidacademy.fixit.core.presentation.BaseFragment

object NavigationUtils {
    fun openFragment(
        fragment: BaseFragment,
        fragmentManager: FragmentManager,
        @IdRes container: Int,
        tag: String,
        addStack: Boolean
    ) {
        val transactionManager = fragmentManager.beginTransaction()
        if (addStack) transactionManager.addToBackStack(tag)
        transactionManager.replace(container, fragment, tag).commit()
    }
}