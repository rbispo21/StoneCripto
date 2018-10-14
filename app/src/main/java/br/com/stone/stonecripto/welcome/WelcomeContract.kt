package br.com.stone.stonecripto.welcome

import android.content.Context
import android.content.Intent

interface WelcomeContract {
    interface View {
        fun callActivity(intent: Intent)
        fun closeActivity()
    }

    interface Presenter {
        fun clickContinue(context: Context)
    }
}