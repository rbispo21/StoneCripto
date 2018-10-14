package br.com.stone.stonecripto.register

import android.content.Context
import br.com.stone.stonecripto.manager.UserRepository


class RegisterPresenter(val view: RegisterContract.View, val userManager: UserRepository): RegisterContract.Presenter {
    override fun clickRegister(context: Context, name: String) {
        userManager.saveName(name)
    }
}