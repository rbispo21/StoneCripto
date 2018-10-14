package br.com.stone.stonecripto.di.component

import dagger.Component
import br.com.stone.stonecripto.di.module.WelcomeModule
import br.com.stone.stonecripto.welcome.WelcomeActivity

@Component(modules = [WelcomeModule::class])
interface WelcomeComponent {
    fun inject(welcomeView: WelcomeActivity)
}