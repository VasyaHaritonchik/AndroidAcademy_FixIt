package com.androidacademy.fixit.core.presentation.targetsList.view

import android.view.View
import com.androidacademy.fixit.core.data.Target
import com.androidacademy.fixit.utils.recycler.BaseRecyclerAdapter
import com.androidacademy.fixit.utils.recycler.BaseViewHolder

class TargetListAdapter(items: List<Target>, itemClick: (Target) -> Unit) :
    BaseRecyclerAdapter<Target>(items, itemClick) {
    override fun getHolderLayout(viewType: Int): Int =
        TargetListHolder.LAYOUT

    override fun getHolder(view: View): BaseViewHolder<Target> =
        TargetListHolder(view)
}