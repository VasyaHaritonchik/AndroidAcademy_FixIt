package com.androidacademy.fixit.core.presentation.servicesList.adapter

import android.view.View
import androidx.annotation.LayoutRes
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.data.ServicesName
import com.androidacademy.fixit.utils.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.item_service.view.*

class ServiceHolder(itemView: View) : BaseViewHolder<ServicesName>(itemView) {
    override fun bind(item: ServicesName) {
        itemView.tv_title.text = item.name
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_service
    }
}