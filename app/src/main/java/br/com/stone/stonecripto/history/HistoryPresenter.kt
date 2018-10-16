package br.com.stone.stonecripto.history

import br.com.stone.stonecripto.manager.CoinManager
import br.com.stone.stonecripto.manager.CoinRepository

class HistoryPresenter(val view: HistoryContract.View,
                       val coinManager: CoinRepository): HistoryContract.Presenter {
    override fun load() {
        val trasaction = coinManager.getAllTransaction()
        if (trasaction.count() > 0) {
            view.buildList(HistoryAdapter(trasaction))
            view.hideMessageEmpty()
        } else {
            view.showMessageEmpty()
        }
    }
}