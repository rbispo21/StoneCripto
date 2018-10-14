package br.com.stone.stonecripto.di.module

import android.content.Context
import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.registerSuccess.RegisterSuccessContract
import br.com.stone.stonecripto.registerSuccess.RegisterSuccessPresenter
import dagger.Module
import dagger.Provides

@Module
class RegisterSuccessModule(val context: Context, val view: RegisterSuccessContract.View) {
    @Provides
    fun providerUserRepository(): UserRepository {
        return UserManager(context)
    }

    @Provides
    fun providerRegisterSuccess(userManager: UserRepository): RegisterSuccessContract.Presenter {
        return RegisterSuccessPresenter(view, userManager)
    }
}