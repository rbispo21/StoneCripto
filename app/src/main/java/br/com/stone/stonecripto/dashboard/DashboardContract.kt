package br.com.stone.stonecripto.dashboard

interface DashboardContract {
    interface View {
        fun setFriendlyMessage(text: String)
        fun setBalanceReal(text: String)
        fun setBalanceCripto(text: String)
        fun setPriceBuy(text: String)
        fun setPriceSell(text: String)
        fun setNameCoin(text: String)
        fun hideKeyboard()
    }

    interface Presenter {
        fun load()
//        fun clickBuy(amount: Double)
//        fun clickSell(amount: Double)
    }
}