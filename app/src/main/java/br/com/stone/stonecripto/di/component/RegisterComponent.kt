package br.com.stone.stonecripto.di.component

import br.com.stone.stonecripto.di.module.RegisterModule
import br.com.stone.stonecripto.register.RegisterActivity
import dagger.Component

@Component(modules = [RegisterModule::class])
interface RegisterComponent {
    fun inject(registerView: RegisterActivity)
}