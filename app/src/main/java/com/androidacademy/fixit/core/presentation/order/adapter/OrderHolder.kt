package com.androidacademy.fixit.core.presentation.order.adapter

import android.view.View
import androidx.annotation.LayoutRes
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.utils.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.order_item.view.*

class OrderHolder(
    itemView: View
) : BaseViewHolder<Order>(itemView) {

    override fun bind(item: Order) {
        with(itemView) {
            val address = item.address
            apartments.text = address.apartments.toString()
            building.text = address.building.toString()
            floor.text = address.floor.toString()
            house.text = address.house.toString()
            porch.text = address.porch.toString()
            street.text = address.street
            price.text = item.finalPrice.toString()
            date.text = item.dataTime
            status.text = when {
                item.isCompleted -> context.getString(R.string.be_in_progress)
                item.isProcessing -> context.getString(R.string.done)
                else -> ""
            }
            var ordersText = ""
            item.serviceTargets.forEach {
                ordersText += "${it}, "
            }
            orders.text = ordersText
        }

    }

    companion object {
        @LayoutRes const val LAYOUT = R.layout.order_item
    }
}