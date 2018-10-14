package br.com.stone.stonecripto.home

import androidx.fragment.app.Fragment


interface HomeContract {
    interface View {
        fun changeFragment(fragment: Fragment)
    }

    interface Presenter {
        fun clickDashboard()
        fun clickHistory()
    }
}