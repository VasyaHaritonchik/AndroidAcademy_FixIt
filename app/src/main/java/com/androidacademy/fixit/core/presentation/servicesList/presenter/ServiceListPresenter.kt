package com.androidacademy.fixit.core.presentation.servicesList.presenter

import com.androidacademy.fixit.core.data.ServicesName
import com.androidacademy.fixit.core.presentation.servicesList.view.ServiceListView
import com.androidacademy.fixit.core.repositories.MainRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class ServiceListPresenter @Inject constructor(
    private val repository: MainRepository
) : MvpPresenter<ServiceListView>() {

    fun getData() {
        viewState.showLoadingView(true)
        repository.getServices { updateData(it) }
    }

    private fun updateData(items: List<ServicesName>) {
        viewState.update(items)
        viewState.showLoadingView(false)
    }
}