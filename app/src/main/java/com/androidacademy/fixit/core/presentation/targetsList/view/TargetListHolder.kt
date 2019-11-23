package com.androidacademy.fixit.core.presentation.targetsList.view

import android.view.View
import androidx.annotation.LayoutRes
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.data.Target
import com.androidacademy.fixit.utils.recycler.BaseViewHolder
import kotlinx.android.synthetic.main.target_list_item.view.*


class TargetListHolder(itemView: View) : BaseViewHolder<Target>(itemView) {
    override fun bind(item: Target) {
        itemView.target_name.text = item.name
        if (item.isSelected) {
            itemView.target_checkbox.visibility = View.INVISIBLE
        } else {
            itemView.target_checkbox.visibility = View.VISIBLE
        }
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.target_list_item
    }
}