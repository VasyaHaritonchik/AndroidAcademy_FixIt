package com.androidacademy.fixit.core.presentation.servicesList.view

import android.view.View
import com.androidacademy.fixit.core.data.ServicesName
import com.androidacademy.fixit.core.presentation.servicesList.adapter.ServiceHolder
import com.androidacademy.fixit.utils.recycler.BaseRecyclerAdapter
import com.androidacademy.fixit.utils.recycler.BaseViewHolder

class ServiceAdapter(items: List<ServicesName>, itemClick: (ServicesName, Int) -> Unit) :
    BaseRecyclerAdapter<ServicesName>(items, itemClick) {
    override fun getHolderLayout(viewType: Int): Int =
        ServiceHolder.LAYOUT

    override fun getHolder(view: View): BaseViewHolder<ServicesName> =
        ServiceHolder(view)
}