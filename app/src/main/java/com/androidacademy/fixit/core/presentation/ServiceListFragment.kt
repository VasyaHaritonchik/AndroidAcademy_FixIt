package com.androidacademy.fixit.core.presentation


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.network.Service
import com.androidacademy.fixit.utils.navigation.NavigationUtils


/**
 * A simple [Fragment] subclass.
 */
class ServiceListFragment : BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_service_list
    override fun title(): String = requireContext().getString(R.string.what_should_be_done)

    private fun click(service: Service) {
        NavigationUtils.openFragment(
            TargetsFragment.getInstance(service.id, service.name),
            requireFragmentManager(),
            R.id.fragment_container,
            TARGETS_FRAGMENT,
            true
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter =
            ServiceAdapter(
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
        private const val TARGETS_FRAGMENT = "targets_fragment"

        val list =
            listOf(Service(0, "Сантехнические работы"), Service(1, "работы"), Service(2, "услуги"))

        fun getInstance(): BaseFragment =
            ServiceListFragment()
    }
}
