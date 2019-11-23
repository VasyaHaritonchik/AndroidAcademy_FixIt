package com.androidacademy.fixit.core.presentation.servicesList


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidacademy.fixit.R
import com.androidacademy.fixit.core.App
import com.androidacademy.fixit.core.data.ServicesName
import com.androidacademy.fixit.core.presentation.BaseFragment
import com.androidacademy.fixit.core.presentation.servicesList.adapter.ServiceAdapter
import com.androidacademy.fixit.core.presentation.servicesList.presenter.ServiceListPresenter
import com.androidacademy.fixit.core.presentation.servicesList.view.ServiceListView
import com.androidacademy.fixit.core.presentation.targetsList.view.TargetListFragment
import com.androidacademy.fixit.utils.navigation.NavigationUtils
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.Lazy
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ServiceListFragment : BaseFragment(), ServiceListView {

    @Inject
    lateinit var daggerPresenter: Lazy<ServiceListPresenter>

    @InjectPresenter
    lateinit var presenter: ServiceListPresenter

    @ProvidePresenter
    fun providePresenter(): ServiceListPresenter {
        App.instanse.appComponent.inject(this)
        return daggerPresenter.get()
    }

    override fun layoutRes(): Int = R.layout.fragment_service_list
    override fun title(): String = requireContext().getString(R.string.what_should_be_done)

    private val adapter by lazy { ServiceAdapter(itemClick = ::click) }

    private fun click(service: ServicesName) {
        NavigationUtils.openFragment(
            TargetListFragment.getInstance(service.id, service.name),
            requireFragmentManager(),
            R.id.fragment_container,
            TARGETS_FRAGMENT,
            true
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            (recyclerView.layoutManager as LinearLayoutManager).orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        presenter.getData()
    }

    override fun update(items: List<ServicesName>) {
        adapter.update(items)
    }


    companion object {
        private const val TARGETS_FRAGMENT = "targets_fragment"

        fun getInstance(): BaseFragment =
            ServiceListFragment()
    }
}
