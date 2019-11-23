package com.androidacademy.fixit.core.presentation.targetsList.view

import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.core.presentation.BaseView
import com.androidacademy.fixit.core.presentation.address.AddressFragment

interface TargetListView: BaseView {
    fun updateItems(items: List<ServiceTarget>)

    fun setResultView(itemsCount: Long)

    fun enableResultView(enable: Boolean)

    fun openChoiceAddress(fragment: BaseFragment)
}