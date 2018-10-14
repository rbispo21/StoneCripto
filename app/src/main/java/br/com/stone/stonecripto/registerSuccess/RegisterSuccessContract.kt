package br.com.stone.stonecripto.registerSuccess

interface RegisterSuccessContract {
    interface View {
        fun hideAnimation()
        fun showMessageSuccess(name: String)
    }

    interface Presenter {
        fun animationFinish()
    }
}