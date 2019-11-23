package com.androidacademy.fixit.core.presentation.targetsList.adapter

import android.view.View
import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.utils.recycler.BaseRecyclerAdapter
import com.androidacademy.fixit.utils.recycler.BaseViewHolder


class TargetListAdapter(items: List<ServiceTarget> = listOf(), itemClick: (ServiceTarget, Int) -> Unit) :
    BaseRecyclerAdapter<ServiceTarget>(items, itemClick) {
    override fun getHolderLayout(viewType: Int): Int =
        TargetListHolder.LAYOUT

    override fun getHolder(view: View): BaseViewHolder<ServiceTarget> =
        TargetListHolder(view)
}