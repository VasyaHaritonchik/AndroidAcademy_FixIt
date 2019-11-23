package com.androidacademy.fixit.core.presentation.order.presenters

import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.core.presentation.order.view.OrderView
import com.androidacademy.fixit.core.repositories.MainRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class OrderPresenter @Inject constructor(
    private val repository: MainRepository
): MvpPresenter<OrderView>() {

    fun getData() {
        viewState.showLoadingView(true)
        repository.getOrder { setData(it) }
    }

    private fun setData(items: List<Order>) {
        viewState.update(items)
        viewState.showLoadingView(false)
    }
}