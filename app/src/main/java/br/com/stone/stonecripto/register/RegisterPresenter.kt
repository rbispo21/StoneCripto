package br.com.stone.stonecripto.register

import android.content.Context
import android.content.Intent
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.registerSuccess.RegisterSuccessActivity


class RegisterPresenter(val view: RegisterContract.View, val userManager: UserRepository): RegisterContract.Presenter {
    override fun clickRegister(context: Context, name: String) {
        userManager.saveName(name)
        view.callActivity(Intent(context, RegisterSuccessActivity::class.java))
        view.closeActivity()
    }
}