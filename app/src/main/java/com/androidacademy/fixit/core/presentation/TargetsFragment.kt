package com.androidacademy.fixit.core.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidacademy.fixit.R

/**
 * A simple [Fragment] subclass.
 */
class TargetsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_targets, container, false)
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        fun getInstance(id: Long): TargetsFragment {
            val bundle = Bundle(1)
            val fragment =
                TargetsFragment()
            bundle.putLong(ARG_ID, id)
            fragment.arguments = bundle
            return fragment
        }
    }
}
