package br.com.stone.stonecripto.registerSuccess

import br.com.stone.stonecripto.manager.UserRepository

class RegisterSuccessPresenter(val view: RegisterSuccessContract.View,
                               val userManager: UserRepository): RegisterSuccessContract.Presenter {
    override fun animationFinish() {
        view.hideAnimation()
        view.showMessageSuccess(userManager.getUserName())
    }
}