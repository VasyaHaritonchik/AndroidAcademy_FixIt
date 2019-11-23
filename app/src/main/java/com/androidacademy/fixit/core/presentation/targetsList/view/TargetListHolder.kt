package com.androidacademy.fixit.core.presentation.targetsList.view

import android.view.View
import androidx.annotation.LayoutRes
import com.androidacademy.fixit.R
import com.androidacademy.fixit.utils.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.item_service.view.*

class TargetListHolder(itemView: View) : BaseViewHolder<Target>(itemView) {
    override fun bind(item: Target) {
        itemView.tv_title.text = item.name
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_service
    }
}