package com.androidacademy.fixit.core.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.network.Service


/**
 * A simple [Fragment] subclass.
 */
class ServiceListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service_list, container, false)
    }

    private fun click(service: Service) {
        requireFragmentManager().beginTransaction()
            .replace(
                android.R.id.content,
                TargetsFragment.getInstance(
                    service.id
                )
            )
            .addToBackStack(null)
            .commit()
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
        val list =
            listOf(Service(0, "Сантехнические работы"), Service(1, "работы"), Service(2, "услуги"))

        fun getInstance(): Fragment =
            ServiceListFragment()
    }
}
