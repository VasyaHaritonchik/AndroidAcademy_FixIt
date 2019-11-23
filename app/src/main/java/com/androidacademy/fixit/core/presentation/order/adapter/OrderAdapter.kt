package com.androidacademy.fixit.core.presentation.order.adapter

import android.view.View
import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.utils.recycler.BaseRecyclerAdapter
import com.androidacademy.fixit.utils.recycler.BaseViewHolder

class OrderAdapter: BaseRecyclerAdapter<Order>() {
    override fun getHolderLayout(viewType: Int): Int = OrderHolder.LAYOUT

    override fun getHolder(view: View): BaseViewHolder<Order> = OrderHolder(view)
}