package br.com.stone.stonecripto.history

import br.com.stone.stonecripto.manager.CoinManager

class HistoryPresenter(val view: HistoryContract.View): HistoryContract.Presenter {
    override fun load() {
        val trasaction = CoinManager.getAllTransaction()
        if (trasaction.count() > 0) {
            view.buildList(HistoryAdapter(trasaction))
            view.hideMessageEmpty()
        } else {
            view.showMessageEmpty()
        }
    }
}