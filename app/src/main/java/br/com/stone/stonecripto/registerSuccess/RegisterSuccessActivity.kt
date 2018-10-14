package br.com.stone.stonecripto.registerSuccess

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.stone.stonecripto.R
import br.com.stone.stonecripto.di.component.DaggerRegisterSuccessComponent
import br.com.stone.stonecripto.di.module.RegisterSuccessModule
import kotlinx.android.synthetic.main.activity_register_success.*
import javax.inject.Inject

class RegisterSuccessActivity : AppCompatActivity(), RegisterSuccessContract.View {
    @Inject lateinit var presenter: RegisterSuccessContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerRegisterSuccessComponent
            .builder()
            .registerSuccessModule(RegisterSuccessModule(this, this)).
                build()
                .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_success)

        animationMonitore()
    }

    fun animationMonitore() {
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {}
            override fun onAnimationEnd(p0: Animator?) {
                presenter.animationFinish()
            }
            override fun onAnimationStart(p0: Animator?) {}
            override fun onAnimationCancel(p0: Animator?) {}
        })
    }

    override fun hideAnimation() {
        animationView.visibility = View.INVISIBLE
    }

    override fun showMessageSuccess(name: String) {
        imgProfit.visibility = View.VISIBLE
        txtBonus.visibility = View.VISIBLE
        txtDescription.text = "$name, Você ganhou um bonus por se cadastrar na maior exchange do Brasil!"
        txtDescription.visibility = View.VISIBLE
        btnContinue.visibility = View.VISIBLE
    }
}
