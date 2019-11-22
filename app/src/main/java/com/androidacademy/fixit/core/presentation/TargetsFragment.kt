package com.androidacademy.fixit.core.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.androidacademy.fixit.R

/**
 * A simple [Fragment] subclass.
 */
class TargetsFragment : BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_targets
    override fun title(): String = arguments?.getString(NAME_ID) ?: ""

    companion object {
        private const val ARG_ID = "ARG_ID"
        private const val NAME_ID = "NAME_ID"
        fun getInstance(id: Long, title: String): BaseFragment {
            val bundle = Bundle(1)
            val fragment =
                TargetsFragment()
            bundle.putLong(ARG_ID, id)
            bundle.putString(NAME_ID, title)
            fragment.arguments = bundle
            return fragment
        }
    }
}
