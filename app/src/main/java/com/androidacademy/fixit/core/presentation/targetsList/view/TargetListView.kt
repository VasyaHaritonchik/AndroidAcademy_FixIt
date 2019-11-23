package com.androidacademy.fixit.core.presentation.targetsList.view

import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.core.presentation.BaseView

interface TargetListView: BaseView {
    fun updateItems(items: List<ServiceTarget>)

    fun setResultView(itemsCount: Long)

    fun enableResultView(enable: Boolean)
}