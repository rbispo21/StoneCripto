package br.com.stone.stonecripto.di.module

import android.content.Context
import br.com.stone.stonecripto.dashboard.DashboardContract
import br.com.stone.stonecripto.dashboard.DashboardPresenter
import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.manager.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DashboardModule(val context: Context, val view: DashboardContract.View) {
    @Provides
    fun providerUserRepository(): UserRepository {
        return UserManager(context)
    }
    @Provides
    fun providerDashBoardPresenter(userManager: UserRepository): DashboardContract.Presenter {
        return DashboardPresenter(view, userManager)
    }
}