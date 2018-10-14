package br.com.stone.stonecripto.di.module

import android.content.Context
import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.register.RegisterContract
import br.com.stone.stonecripto.register.RegisterPresenter
import dagger.Module
import dagger.Provides

@Module
class RegisterModule(val context: Context, val view: RegisterContract.View) {
    @Provides
    fun providerUserRepository(): UserRepository {
        return UserManager(context)
    }

    @Provides
    fun providerRegisterPresenter(userManager: UserRepository): RegisterContract.Presenter {
        return RegisterPresenter(view, userManager)
    }
}