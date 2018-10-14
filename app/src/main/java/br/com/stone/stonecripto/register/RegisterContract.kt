package br.com.stone.stonecripto.register

import android.content.Context
import android.content.Intent

interface RegisterContract {
    interface View {
        fun callActivity(intent: Intent)
        fun closeActivity()
    }

    interface Presenter {
        fun clickRegister(context: Context, name: String)
    }
}