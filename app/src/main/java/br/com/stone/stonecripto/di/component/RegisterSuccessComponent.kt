package br.com.stone.stonecripto.di.component

import br.com.stone.stonecripto.di.module.RegisterSuccessModule
import br.com.stone.stonecripto.registerSuccess.RegisterSuccessActivity
import dagger.Component

@Component(modules = [RegisterSuccessModule::class])
interface RegisterSuccessComponent {
    fun inject(registerSuccessAcitivity: RegisterSuccessActivity)
}