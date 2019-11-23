package com.androidacademy.fixit.core.presentation.order

import androidx.recyclerview.widget.LinearLayoutManager
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App
import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.core.presentation.order.adapter.OrderAdapter
import com.androidacademy.fixit.core.presentation.order.presenters.OrderPresenter
import com.androidacademy.fixit.core.presentation.order.view.OrderView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_order.*
import javax.inject.Inject

class OrderFragment : BaseFragment(), OrderView {

    @Inject
    lateinit var daggerPresenter: Lazy<OrderPresenter>

    @InjectPresenter
    lateinit var presenter: OrderPresenter

    @ProvidePresenter
    fun provide(): OrderPresenter {
        App.instanse.appComponent.inject(this)
        return daggerPresenter.get()
    }

    override fun layoutRes(): Int = R.layout.fragment_order

    override fun title(): String = requireContext().getString(R.string.your_orders)

    private val adapter: OrderAdapter by lazy { OrderAdapter() }

    override fun initView() {
        super.initView()
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        presenter.getData()
    }

    override fun update(items: List<Order>) {
        adapter.update(items)
    }


    companion object {
        fun newInstance(): OrderFragment =
            OrderFragment().apply {  }
    }
}