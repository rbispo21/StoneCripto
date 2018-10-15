package br.com.stone.stonecripto.registerSuccess

import android.content.Context
import android.content.Intent
import br.com.stone.stonecripto.home.HomeActivity
import br.com.stone.stonecripto.manager.CoinManager
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.model.CoinType

class RegisterSuccessPresenter(val view: RegisterSuccessContract.View,
                               val userManager: UserRepository): RegisterSuccessContract.Presenter {
    override fun clickContinue(context: Context) {
        view.callActivity(Intent(context, HomeActivity::class.java))
        view.closeActivity()
    }

    override fun animationFinish() {
        view.hideAnimation()
        view.showMessageSuccess(userManager.getUserName())
        val coinManager = CoinManager()
        coinManager.addBalanceInitial(CoinType.BRL)
    }
}