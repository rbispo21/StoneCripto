package br.com.stone.stonecripto.dashboard

import br.com.stone.stonecripto.api.RemoteRepository
import br.com.stone.stonecripto.currencyString
import br.com.stone.stonecripto.listener.QuotationListener
import br.com.stone.stonecripto.manager.CoinManager
import br.com.stone.stonecripto.manager.CoinRepository
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.model.CoinType
import br.com.stone.stonecripto.model.Quotation

class DashboardPresenter(val view: DashboardContract.View,
                         val userManager: UserRepository,
                         val coinManager: CoinRepository): DashboardContract.Presenter, QuotationListener {
    var typeCoinSelected = CoinType.BTC
    var marketClose = false

    override fun load() {
        view.setFriendlyMessage("Olá, ${userManager.getUserName()} sejam bem vindo")
        updateBalance()
        view.setNameCoin(typeCoinSelected.name)
        updateQuotation()
        view.hideKeyboard()
    }

    fun updateQuotation() {
        RemoteRepository.getQuotation(typeCoinSelected, this)
    }

    fun updateBalance() {
        view.setBalanceReal("Saldo: ${coinManager.getBalance(CoinType.BRL).currencyString()}")
        view.setBalanceCripto("Saldo: ${coinManager.getBalance(typeCoinSelected)} ${typeCoinSelected.name}")
    }

    override fun success(quotation: Quotation) {
        coinManager.updatePrice(typeCoinSelected, quotation.priceBuy, quotation.priceSell)
        view.setPriceBuy("Preço de compra: ${quotation.priceBuy.currencyString()}")
        view.setPriceSell("Preço de venda: ${quotation.priceSell.currencyString()}")
    }

    override fun failure() {
        marketClose = true
    }

    override fun closeMarket() {
        marketClose = true
    }

    override fun clickBuy(amount: String) {
        if (amount.isNotEmpty()) {
            view.hideKeyboard()
            if (coinManager.buyCoin(typeCoinSelected, amount.toDouble())) {
                updateBalance()
                view.clearEdit()
                view.showAlert("Compra realizada", "Compra realizada com sucesso")
            } else {
                view.showAlert("Falha na compra", "Você não possui saldo para fazer essa operação")
            }
        } else {
            view.showAlert("Falha na compra", "Digite um valor a ser comprado")
        }
    }

    override fun clickSell(amount: String) {
        if (amount.isNotEmpty()) {
            view.hideKeyboard()
            if (coinManager.sellCoin(typeCoinSelected, amount.toDouble())) {
                updateBalance()
                view.clearEdit()
                view.showAlert("Venda realizada", "Venda realizada com sucesso")
            } else {
                view.showAlert("Falha na venda", "Você não possui saldo para fazer essa operação")
            }
        } else {
            view.showAlert("Falha na venda", "Digite um valor a ser vendido")
        }
    }

    override fun clickChangeCoin() {
        if (typeCoinSelected == CoinType.BTC)
            typeCoinSelected = CoinType.BRI
        else
            typeCoinSelected = CoinType.BTC

        load()
    }
}