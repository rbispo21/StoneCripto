package br.com.stone.stonecripto.di.module

import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.register.RegisterContract
import br.com.stone.stonecripto.register.RegisterPresenter
import dagger.Module
import dagger.Provides

@Module
class RegisterModule(val view: RegisterContract.View) {
    @Provides
    fun providerRegisterPresenter(): RegisterContract.Presenter {
        return RegisterPresenter(view, UserManager())
    }
}