package br.com.stone.stonecripto.welcome

import android.content.Context
import android.content.Intent
import br.com.stone.stonecripto.register.RegisterActivity

class WelcomePresenter(val view: WelcomeContract.View): WelcomeContract.Presenter {
    override fun clickContinue(context: Context) {
        val intent = Intent(context, RegisterActivity::class.java)
        view.callActivity(intent)
        view.closeActivity()
    }
}