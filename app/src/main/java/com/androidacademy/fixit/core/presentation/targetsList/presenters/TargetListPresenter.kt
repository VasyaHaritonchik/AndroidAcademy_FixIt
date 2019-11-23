package com.androidacademy.fixit.core.presentation.targetsList.presenters

import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.core.presentation.targetsList.view.TargetListView
import com.androidacademy.fixit.core.repositories.MainRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class TargetListPresenter @Inject constructor(
    private val repository: MainRepository
) : MvpPresenter<TargetListView>() {

    fun getData(id: String) {
        viewState.showLoadingView(true)
        repository.getServiceTargets(id, { update(it) })
    }

    fun checkItems(items: List<ServiceTarget>) {
        val itemsCount = items.filter { it.isSelected }.size
        if (itemsCount != 0) {
            viewState.setResultView(itemsCount.toLong())
            viewState.enableResultView(true)
        } else viewState.enableResultView(false)
    }

    private fun update(items: List<ServiceTarget>) {
        viewState.updateItems(items)
        viewState.showLoadingView(false)
    }
}