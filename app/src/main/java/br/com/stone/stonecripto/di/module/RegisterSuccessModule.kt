package br.com.stone.stonecripto.di.module

import br.com.stone.stonecripto.manager.CoinManager
import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.registerSuccess.RegisterSuccessContract
import br.com.stone.stonecripto.registerSuccess.RegisterSuccessPresenter
import dagger.Module
import dagger.Provides

@Module
class RegisterSuccessModule(val view: RegisterSuccessContract.View) {
    @Provides
    fun providerRegisterSuccess(): RegisterSuccessContract.Presenter {
        return RegisterSuccessPresenter(view, UserManager(), CoinManager())
    }
}