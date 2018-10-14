package br.com.stone.stonecripto.welcome

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.stone.stonecripto.R
import br.com.stone.stonecripto.di.component.DaggerWelcomeComponent
import br.com.stone.stonecripto.di.module.WelcomeModule
import kotlinx.android.synthetic.main.activity_welcome.*
import javax.inject.Inject

class WelcomeActivity : AppCompatActivity(), WelcomeContract.View {
    @Inject
    lateinit var presenter: WelcomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerWelcomeComponent.builder()
            .welcomeModule(WelcomeModule(this)).build().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        configureClickButton()
    }

    private fun configureClickButton() {
        btnContinue.setOnClickListener {
            presenter.clickContinue(this)
        }
    }

    override fun closeActivity() {
        finish()
    }

    override fun callActivity(intent: Intent) {
        startActivity(intent)
    }
}