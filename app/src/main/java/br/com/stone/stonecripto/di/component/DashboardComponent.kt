package br.com.stone.stonecripto.di.component

import br.com.stone.stonecripto.dashboard.DashboardFragment
import br.com.stone.stonecripto.di.module.DashboardModule
import dagger.Component

@Component(modules = [DashboardModule::class])
interface DashboardComponent {
    fun inject(dashboard: DashboardFragment)
}