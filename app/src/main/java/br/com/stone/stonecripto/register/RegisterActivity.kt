package br.com.stone.stonecripto.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.stone.stonecripto.R
import br.com.stone.stonecripto.di.component.DaggerRegisterComponent
import br.com.stone.stonecripto.di.module.RegisterModule
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity(), RegisterContract.View {
    @Inject lateinit var presenter: RegisterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerRegisterComponent.builder().registerModule(RegisterModule(this, this)).build().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        configureTitle()
        configureButton()
    }

    fun configureButton() {
        btnRegister.setOnClickListener {
            presenter.clickRegister(this, edtName.text.toString())
        }
    }

    fun configureTitle() {
        supportActionBar?.title = "Cadastrar"
    }

    override fun callActivity(intent: Intent) {
        startActivity(intent)
    }

    override fun closeActivity() {
        finish()
    }
}
