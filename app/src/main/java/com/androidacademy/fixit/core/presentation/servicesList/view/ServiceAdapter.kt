package com.androidacademy.fixit.core.presentation.servicesList.view

import android.view.View
import com.androidacademy.fixit.core.network.Service
import com.androidacademy.fixit.core.presentation.servicesList.view.ServiceHolder
import com.androidacademy.fixit.utils.recycler.BaseRecyclerAdapter
import com.androidacademy.fixit.utils.recycler.BaseViewHolder

class ServiceAdapter(items: List<Service>, itemClick: (Service) -> Unit) :
    BaseRecyclerAdapter<Service>(items, itemClick) {
    override fun getHolderLayout(viewType: Int): Int =
        ServiceHolder.LAYOUT

    override fun getHolder(view: View): BaseViewHolder<Service> =
        ServiceHolder(view)
}