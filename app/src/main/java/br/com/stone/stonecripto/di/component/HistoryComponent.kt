package br.com.stone.stonecripto.di.component

import br.com.stone.stonecripto.di.module.HistoryModule
import br.com.stone.stonecripto.di.module.HomeModule
import br.com.stone.stonecripto.history.HistoryFragment
import br.com.stone.stonecripto.home.HomeActivity
import dagger.Component

@Component(modules = [HistoryModule::class])
interface HistoryComponent {
    fun inject(history: HistoryFragment)
}