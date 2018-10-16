package br.com.stone.stonecripto.di.module

import br.com.stone.stonecripto.dashboard.DashboardContract
import br.com.stone.stonecripto.dashboard.DashboardPresenter
import br.com.stone.stonecripto.manager.UserManager
import dagger.Module
import dagger.Provides

@Module
class DashboardModule(val view: DashboardContract.View) {
    @Provides
    fun providerDashBoardPresenter(): DashboardContract.Presenter {
        return DashboardPresenter(view, UserManager())
    }
}