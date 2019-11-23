package com.androidacademy.fixit.core.presentation.targetsList.view


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.presentation.BaseFragment

/**
 * A simple [Fragment] subclass.
 */
class TargetListFragment : BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_target_list
    override fun title(): String = arguments?.getString(NAME_ID) ?: ""

    private fun click(target: Target) {
        Toast.makeText(context,"this is toast message", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.target_list_view)
        recyclerView.adapter =
            TargetListAdapter(
                list,
                ::click
            )
        recyclerView.layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            (recyclerView.layoutManager as LinearLayoutManager).orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        private const val NAME_ID = "NAME_ID"

        val list =
            listOf(
                Target(0, "работы", false),
                Target(1, "eee", false),
                Target(2, "lol", false)
            )

        fun getInstance(id: Long, title: String): BaseFragment {
            val bundle = Bundle(1)
            val fragment =
                TargetListFragment()
            bundle.putLong(ARG_ID, id)
            bundle.putString(NAME_ID, title)
            fragment.arguments = bundle
            return fragment
        }
    }
}
