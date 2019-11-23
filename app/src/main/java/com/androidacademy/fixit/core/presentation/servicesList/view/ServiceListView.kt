package com.androidacademy.fixit.core.presentation.servicesList.view

import com.androidacademy.fixit.core.data.ServicesName
import com.androidacademy.fixit.core.presentation.BaseView

interface ServiceListView: BaseView {

    fun update(items: List<ServicesName>)
}