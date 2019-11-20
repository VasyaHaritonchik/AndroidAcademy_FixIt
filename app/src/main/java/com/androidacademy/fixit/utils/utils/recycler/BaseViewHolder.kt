package com.androidacademy.fixit.utils.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer


abstract class BaseViewHolder<T>(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    open fun bind(item: T) {}
}
