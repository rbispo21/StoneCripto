package br.com.stone.stonecripto.api

import android.util.Log
import br.com.stone.stonecripto.listener.QuotationListener
import br.com.stone.stonecripto.model.CoinType
import br.com.stone.stonecripto.model.Quotation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

object RemoteRepository {
    val retryMax = 5
    var retry = 0
    fun getQuotation(type: CoinType, listener: QuotationListener) {
        when (type) {
            CoinType.BRI -> {
                val dateFormat = SimpleDateFormat("MM-dd-yyyy")
                val date = Date()
                val dateString = "'${dateFormat.format(date)}'"
                Log.d("teste", "date: $dateString")
                BankCentralService.instance.getCriptoPrice(dateString, "json")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({bankCentralModelRest ->
                        if (bankCentralModelRest.value.count() > 0) {
                            retry = 0
                            val quotationModelRest = bankCentralModelRest.value[0]
                            val quotation = Quotation(quotationModelRest.sell, quotationModelRest.buy, type)
                            listener.success(quotation)
                        } else {
                            if (retry >= retryMax) {
                                listener.closeMarket()
                            } else {
                                retry ++
                                getQuotation(type, listener)
                            }
                        }
                    }, {error ->
                        listener.failure()
                    })
            }
            CoinType.BRL -> listener.closeMarket()
            else -> {
                MarketBTCService.instance.getCriptoPrice(type.name)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({tickerModelRest ->
                        val quotation = Quotation(tickerModelRest.ticker.priceSell, tickerModelRest.ticker.priceBuy, type)
                        listener.success(quotation)
                    }, {error ->
                        listener.failure()
                    })
            }
        }
    }
}