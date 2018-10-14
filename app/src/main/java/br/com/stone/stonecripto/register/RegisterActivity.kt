package br.com.stone.stonecripto.register

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.stone.stonecripto.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        configTitle()
    }

    fun configTitle() {
        supportActionBar?.title = "Cadastrar"
    }
}
