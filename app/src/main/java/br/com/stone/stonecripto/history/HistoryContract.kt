package br.com.stone.stonecripto.history

interface HistoryContract {
    interface View {
        fun buildList(adapter: HistoryAdapter)
        fun showMessageEmpty()
        fun hideMessageEmpty()
    }

    interface Presenter {
        fun load()
    }
}