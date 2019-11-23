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
        if (addStack) transactionManager.addToBackStack(tag) else transactionManager.addToBackStack(null)
        transactionManager.replace(container, fragment, tag).commit()
    }

    fun clearBackStack(fragmentManager: FragmentManager) {
        for (i in 0 until fragmentManager.backStackEntryCount - 1) {
            fragmentManager.popBackStack()
        }
    }
}