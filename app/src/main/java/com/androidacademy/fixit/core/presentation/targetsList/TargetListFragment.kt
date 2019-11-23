package com.androidacademy.fixit.core.presentation.targetsList

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App
import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.core.presentation.address.AddressFragment
import com.androidacademy.fixit.core.presentation.targetsList.adapter.TargetListAdapter
import com.androidacademy.fixit.core.presentation.targetsList.presenters.TargetListPresenter
import com.androidacademy.fixit.core.presentation.targetsList.view.TargetListView
import com.androidacademy.fixit.utils.navigation.NavigationUtils
import com.androidacademy.fixit.utils.visibility
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_target_list.*
import javax.inject.Inject


class TargetListFragment : BaseFragment(), TargetListView {

    @Inject
    lateinit var daggerPresenter: Lazy<TargetListPresenter>

    @InjectPresenter
    lateinit var presenter: TargetListPresenter

    @ProvidePresenter
    fun provide(): TargetListPresenter {
        App.instanse.appComponent.inject(this)
        return daggerPresenter.get()
    }

    private val targetListAdapter by lazy {
        TargetListAdapter(itemClick = { click, position -> click(click, position) })
    }

    override fun layoutRes(): Int = R.layout.fragment_target_list

    override fun title(): String = arguments?.getString(NAME_ID) ?: ""

    override fun initView() {
        super.initView()

        target_list_view.adapter = targetListAdapter
        target_list_view.layoutManager = LinearLayoutManager(context)
        presenter.getData(arguments?.getString(ARG_ID, "") ?: "")
        next_step.setOnClickListener { presenter.next(targetListAdapter.getItems()) }
    }

    override fun updateItems(items: List<ServiceTarget>) {
        targetListAdapter.update(items)
    }

    override fun enableResultView(enable: Boolean) {
        result_view.visibility(enable)
    }

    override fun setResultView(itemsCount: Long) {
        choice_count.text = itemsCount.toString()

    }

    override fun openChoiceAddress(fragment: BaseFragment) {
        NavigationUtils.openFragment(
            fragment,
            requireFragmentManager(),
            R.id.fragment_container,
            ADDRESS_FRAGMENT,
            true
        )
    }

    private fun click(target: ServiceTarget, position: Int) {
        target.isSelected = !target.isSelected
        targetListAdapter.notifyItemChanged(position)
        presenter.checkItems(targetListAdapter.getItems())
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        private const val NAME_ID = "NAME_ID"
        private const val WORKER_PRICE = "WORKER_PRICE"
        private const val ADDRESS_FRAGMENT = "ADDRESS_FRAGMENT"

        fun getInstance(id: String, title: String, workerPrice: Long): BaseFragment {
            return TargetListFragment().apply {
                val bundle = Bundle()
                bundle.putString(ARG_ID, id)
                bundle.putString(NAME_ID, title)
                bundle.putLong(WORKER_PRICE, workerPrice)
                this.arguments = bundle
            }
        }
    }
}
