package br.com.stone.stonecripto.dashboard

interface DashboardContract {
    interface View {
        fun setFriendlyMessage(text: String)
        fun setBalanceReal(text: String)
        fun setBalanceCripto(text: String)
    }

    interface Presenter {
        fun load()
    }
}