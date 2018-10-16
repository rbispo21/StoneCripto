package br.com.stone.stonecripto.di.module

import br.com.stone.stonecripto.home.HomeContract
import br.com.stone.stonecripto.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(val view: HomeContract.View) {
    @Provides
    fun providerHomePresenter(): HomeContract.Presenter = HomePresenter(view)
}