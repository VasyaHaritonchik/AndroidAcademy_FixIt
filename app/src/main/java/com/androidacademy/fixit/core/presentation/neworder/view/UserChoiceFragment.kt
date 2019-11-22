package com.androidacademy.fixit.core.presentation.neworder.view

import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.core.presentation.servicesList.view.ServiceListFragment
import com.androidacademy.fixit.utils.navigation.NavigationUtils
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.fragment_create_new_order.*
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class UserChoiceFragment: BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_create_new_order
    override fun title(): String = requireContext().getString(R.string.your_choice)

    override fun initView() {
        RxView.clicks(create_order).map { CREATE_ORDER }
            .mergeWith(RxView.clicks(show_orders).map { SHOW_ORDERS })
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                when(it) {
                    CREATE_ORDER -> {
                        NavigationUtils.openFragment(
                            ServiceListFragment.getInstance(),
                            requireFragmentManager(),
                            R.id.fragment_container,
                            SERVICE_LIST_FRAGMENT,
                            true
                            )
                    }
                    SHOW_ORDERS -> {}
                }
            },{it.printStackTrace()})
    }

    companion object {
        private const val CREATE_ORDER = "create_order"
        private const val SHOW_ORDERS = "show_orders"
        private const val SERVICE_LIST_FRAGMENT = "service_list_fragment"
        private const val SHOW_ORDERS_FRAGMENT = "show_orders_fragment"

    }
}