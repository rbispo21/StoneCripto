package br.com.stone.stonecripto.dashboard

import br.com.stone.stonecripto.api.RemoteRepository
import br.com.stone.stonecripto.currencyString
import br.com.stone.stonecripto.listener.QuotationListener
import br.com.stone.stonecripto.manager.CoinManager
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.model.CoinType
import br.com.stone.stonecripto.model.Quotation

class DashboardPresenter(val view: DashboardContract.View,
                         val userManager: UserRepository): DashboardContract.Presenter, QuotationListener {
    var typeCoinSelected = CoinType.BTC
    var marketClose = false

    override fun load() {
        view.setFriendlyMessage("Olá, ${userManager.getUserName()} sejam bem vindo")
        view.setBalanceReal("Saldo: ${CoinManager.getBalance(CoinType.BRL).currencyString()}")
        view.setBalanceCripto("Saldo: ${CoinManager.getBalance(typeCoinSelected)} ${typeCoinSelected.name}")
        view.setNameCoin(typeCoinSelected.name)
        updateQuotation()
        view.hideKeyboard()
    }

    fun updateQuotation() {
        RemoteRepository.getQuotation(typeCoinSelected, this)
    }

    override fun success(quotation: Quotation) {
        CoinManager.updatePrice(typeCoinSelected, quotation.priceBuy, quotation.priceSell)
        view.setPriceBuy("Preço de compra: ${quotation.priceBuy.currencyString()}")
        view.setPriceSell("Preço de venda: ${quotation.priceSell.currencyString()}")
    }

    override fun failure() {
        marketClose = true
    }

    override fun closeMarket() {
        marketClose = true
    }
}