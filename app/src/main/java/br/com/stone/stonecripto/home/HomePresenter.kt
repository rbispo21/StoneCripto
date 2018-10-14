package br.com.stone.stonecripto.home

import androidx.fragment.app.Fragment


class HomePresenter(val view: HomeContract.View): HomeContract.Presenter {
    override fun clickDashboard() {
        view.changeFragment(Fragment())
    }

    override fun clickHistory() {
        view.changeFragment(Fragment())
    }
}