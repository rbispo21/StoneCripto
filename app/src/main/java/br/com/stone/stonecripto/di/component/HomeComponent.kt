package br.com.stone.stonecripto.di.component

import br.com.stone.stonecripto.di.module.HomeModule
import br.com.stone.stonecripto.home.HomeActivity
import dagger.Component

@Component(modules = [HomeModule::class])
interface HomeComponent {
    fun inject(home: HomeActivity)
}