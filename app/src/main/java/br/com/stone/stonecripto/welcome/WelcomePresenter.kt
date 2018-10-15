package br.com.stone.stonecripto.welcome

import android.content.Context
import android.content.Intent
import br.com.stone.stonecripto.home.HomeActivity
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.register.RegisterActivity

class WelcomePresenter(val view: WelcomeContract.View, val userManager: UserRepository): WelcomeContract.Presenter {
    override fun create(context: Context) {
        autoLogin(context)
    }

    override fun clickContinue(context: Context) {
        val intent = Intent(context, RegisterActivity::class.java)
        view.callActivity(intent)
        view.closeActivity()
    }

    fun autoLogin(context: Context) {
        if (userManager.hasUser()) {
            val intent = Intent(context, HomeActivity::class.java)
            view.callActivity(intent)
            view.closeActivity()
        }
    }
}