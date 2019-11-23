package com.androidacademy.fixit.core.presentation.targetsList.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.data.Target
import com.androidacademy.fixit.core.presentation.BaseFragment


class TargetListFragment : BaseFragment() {

    val targetListAdapter by lazy { TargetListAdapter(
        list,
        { click, position -> click(click, position) }
    ) }

    private fun click(target: Target, position: Int) {
        target.isSelected = !target.isSelected;

        targetListAdapter.notifyItemChanged(position);
    }


    override fun layoutRes(): Int = R.layout.fragment_target_list

    override fun title(): String = arguments?.getString(NAME_ID) ?: ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.target_list_view)
        recyclerView.adapter = targetListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


    companion object {
        private const val ARG_ID = "ARG_ID"
        private const val NAME_ID = "NAME_ID"

        // TODO: get data from server.
        val list =
            listOf(
                Target(0, "работы", false),
                Target(1, "pop", false),
                Target(2, "lol", false)
            )

        fun getInstance(id: String, title: String): BaseFragment {
            val bundle = Bundle(1)
            val fragment =
                TargetListFragment()
            bundle.putString(ARG_ID, id)
            bundle.putString(NAME_ID, title)
            fragment.arguments = bundle
            return fragment
        }
    }
}
