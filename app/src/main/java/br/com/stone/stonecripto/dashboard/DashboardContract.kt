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
        fun showAlert(title: String, message: String)
        fun clearEdit()
    }

    interface Presenter {
        fun load()
        fun clickBuy(amount: String)
        fun clickSell(amount: String)
        fun clickChangeCoin()
    }
}