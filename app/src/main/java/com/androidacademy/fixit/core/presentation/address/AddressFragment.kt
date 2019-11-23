package com.androidacademy.fixit.core.presentation.address


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog

import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App
import com.androidacademy.fixit.core.data.Address
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.core.presentation.address.presenter.AddressPresenter
import com.androidacademy.fixit.core.presentation.address.view.AddressView
import com.androidacademy.fixit.core.presentation.servicesList.presenter.ServiceListPresenter
import com.androidacademy.fixit.core.presentation.targetsList.TargetListFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_address.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class AddressFragment : BaseFragment(), AddressView {

    @Inject
    lateinit var daggerPresenter: Lazy<AddressPresenter>

    @InjectPresenter
    lateinit var presenter: AddressPresenter

    @ProvidePresenter
    fun providePresenter(): AddressPresenter {
        App.instanse.appComponent.inject(this)
        return daggerPresenter.get()
    }

    override fun layoutRes(): Int = R.layout.fragment_address
    override fun title(): String = requireContext().getString(R.string.welcome)

    override fun initView() {
        super.initView()
        enter_address_button.setOnClickListener {
            val price = arguments!!.getLong(ARG_PRICE)
            val targets = arguments!!.getStringArrayList(ARG_SERVICE_TARGETS)
            presenter.sendOrder(apartment.text.toString().toLong(), building.text.toString().toLong(), floor.text.toString().toLong(), house.text.toString().toLong(), porch.text.toString().toLong(), street.text.toString(),price, targets!!)
        }
    }

    companion object {
        private const val ARG_PRICE = "ARG_PRICE"
        private const val ARG_SERVICE_TARGETS = "ARG_SERVICE_TARGET"

        fun getInstance(price: Long, serviceTargets: ArrayList<String>): BaseFragment {
            return AddressFragment().apply {
                val bundle = Bundle()
                bundle.putLong(ARG_PRICE, price)
                bundle.putStringArrayList(ARG_SERVICE_TARGETS, serviceTargets)
                this.arguments = bundle
            }
        }
    }

    override fun success() {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle("Принято!")
            .setMessage("Ваш заказ направлен свободному мастеру.")
//            .setPositiveButton(android.R.string.ok) { _, {} }
            .show()
    }

}
