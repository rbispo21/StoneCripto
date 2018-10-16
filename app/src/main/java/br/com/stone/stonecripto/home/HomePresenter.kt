package br.com.stone.stonecripto.home

import androidx.fragment.app.Fragment
import br.com.stone.stonecripto.dashboard.DashboardFragment


class HomePresenter(val view: HomeContract.View): HomeContract.Presenter {
    override fun create() {
        clickDashboard()
    }

    override fun clickDashboard() {
        view.changeFragment(DashboardFragment.newInstance())
    }

    override fun clickHistory() {
        view.changeFragment(Fragment())
    }
}