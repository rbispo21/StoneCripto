package br.com.stone.stonecripto.di.module

import br.com.stone.stonecripto.history.HistoryContract
import br.com.stone.stonecripto.history.HistoryPresenter
import dagger.Module
import dagger.Provides

@Module
class HistoryModule(val view: HistoryContract.View) {
    @Provides
    fun providerHistoryPresenter(): HistoryContract.Presenter = HistoryPresenter(view)
}