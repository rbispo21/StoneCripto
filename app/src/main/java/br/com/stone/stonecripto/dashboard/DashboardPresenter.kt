package br.com.stone.stonecripto.dashboard

import br.com.stone.stonecripto.manager.CoinManager
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.model.CoinType

class DashboardPresenter(val view: DashboardContract.View, val userManager: UserRepository): DashboardContract.Presenter {
    val coinManager = CoinManager()
    override fun load() {
        view.setFriendlyMessage("Olá, ${userManager.getUserName()} sejam bem vindo")
        view.setBalanceReal("Saldo: ${coinManager.getBalance(CoinType.BRL)}")
    }
}