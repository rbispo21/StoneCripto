package br.com.stone.stonecripto.register

import android.content.Context
import br.com.stone.stonecripto.manager.UserManager


class RegisterPresenter(val view: RegisterContract.View, val userManager: UserManager): RegisterContract.Presenter {
    override fun clickRegister(context: Context, name: String) {
        userManager.saveNameUser(name)
    }
}