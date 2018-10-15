package br.com.stone.stonecripto.registerSuccess

import android.content.Context
import android.content.Intent

interface RegisterSuccessContract {
    interface View {
        fun hideAnimation()
        fun showMessageSuccess(name: String)
        fun callActivity(intent: Intent)
        fun closeActivity()
    }

    interface Presenter {
        fun animationFinish()
        fun clickContinue(context: Context)
    }
}