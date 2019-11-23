package com.androidacademy.fixit.core.presentation.order.view

import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.core.presentation.BaseView

interface OrderView: BaseView {
    fun update(items: List<Order>)
}