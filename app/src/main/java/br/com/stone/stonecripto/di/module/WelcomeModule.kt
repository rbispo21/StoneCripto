package br.com.stone.stonecripto.di.module

import android.content.Context
import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.welcome.WelcomeContract
import br.com.stone.stonecripto.welcome.WelcomePresenter
import dagger.Module
import dagger.Provides

@Module
class WelcomeModule(val context: Context, val view: WelcomeContract.View) {
    @Provides
    fun providerUserRepository(): UserRepository {
        return UserManager(context)
    }
    @Provides
    fun providerWelcomePresenter(userManager: UserRepository):WelcomeContract.Presenter {
        return WelcomePresenter(view, userManager)
    }
}