package com.androidacademy.fixit.core.presentation.targetsList.adapter

import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.utils.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.target_list_item.view.*


class TargetListHolder(itemView: View) : BaseViewHolder<ServiceTarget>(itemView) {
    override fun bind(item: ServiceTarget) {
        itemView.target_name.text = item.name
        if (!item.isSelected) {
            itemView.target_checkbox.visibility = View.INVISIBLE
            itemView.target_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.primaryTextColor))

        } else {
            itemView.target_checkbox.visibility = View.VISIBLE
            itemView.target_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.action_color))
        }
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.target_list_item
    }
}