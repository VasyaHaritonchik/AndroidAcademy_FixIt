package com.androidacademy.fixit.core.presentation.servicesList.view

import android.view.View
import androidx.annotation.LayoutRes
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.network.Service
import com.androidacademy.fixit.utils.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.item_service.view.*

class ServiceHolder(itemView: View) : BaseViewHolder<Service>(itemView) {
    override fun bind(item: Service) {
        itemView.tv_title.text = item.name
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_service
    }
}