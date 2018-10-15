package br.com.stone.stonecripto.dashboard

import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.manager.UserRepository

class DashboardPresenter(val view: DashboardContract.View, val userManager: UserRepository): DashboardContract.Presenter {
    override fun load() {

    }
}