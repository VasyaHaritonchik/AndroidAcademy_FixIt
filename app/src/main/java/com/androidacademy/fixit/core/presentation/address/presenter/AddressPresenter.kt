package com.androidacademy.fixit.core.presentation.address.presenter

import com.androidacademy.fixit.core.data.Address
import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.core.presentation.address.view.AddressView
import com.androidacademy.fixit.core.presentation.servicesList.view.ServiceListView
import com.androidacademy.fixit.core.repositories.MainRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.android.synthetic.main.fragment_address.*
import java.util.*
import kotlin.collections.ArrayList

@InjectViewState
class AddressPresenter @javax.inject.Inject constructor(
    private val repository: MainRepository
) : MvpPresenter<AddressView>()  {


    fun sendOrder(apartment: Long, building: Long, floor: Long, house: Long, porch: Long, street: String, price: Long, targets: ArrayList<String>) {
        val address = Address(apartment, building, floor, house, porch, street)
        val order = Order(address, Calendar.getInstance().time.toString(), price, serviceTargets = targets)
        repository.setOrder(order, ::success)
    }

    private fun success(){
        viewState.success()
    }
}



