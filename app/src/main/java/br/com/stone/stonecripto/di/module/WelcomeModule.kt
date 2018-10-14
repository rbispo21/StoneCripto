package br.com.stone.stonecripto.di.module

import br.com.stone.stonecripto.welcome.WelcomeContract
import br.com.stone.stonecripto.welcome.WelcomePresenter
import dagger.Module
import dagger.Provides

@Module
class WelcomeModule(val view: WelcomeContract.View) {
    @Provides
    fun providerWelComePresenter():WelcomeContract.Presenter {
        return WelcomePresenter(view)
    }
}