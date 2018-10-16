package br.com.stone.stonecripto.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import br.com.stone.stonecripto.R
import br.com.stone.stonecripto.di.component.DaggerHistoryComponent
import br.com.stone.stonecripto.di.module.HistoryModule
import kotlinx.android.synthetic.main.fragment_history.*
import javax.inject.Inject

class HistoryFragment: Fragment(), HistoryContract.View {
    @Inject lateinit var presenter: HistoryContract.Presenter

    companion object {
        @JvmStatic
        fun newInstance() = HistoryFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerHistoryComponent.builder()
            .historyModule(HistoryModule(this))
            .build().inject(this)
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onResume() {
        super.onResume()
        configuteTitle()
        presenter.load()
    }

    fun configuteTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = "Histórico"
    }

    override fun buildList(adapter: HistoryAdapter) {
        list.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        list.setHasFixedSize(true)
        list.adapter = adapter
    }

    override fun showMessageEmpty() {
        txtEmptyState.visibility = View.VISIBLE
    }

    override fun hideMessageEmpty() {
        txtEmptyState.visibility = View.GONE
    }
}
