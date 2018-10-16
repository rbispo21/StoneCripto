package br.com.stone.stonecripto.listener

import br.com.stone.stonecripto.model.Quotation

interface QuotationListener {
    fun success(quotation: Quotation)
    fun failure()
    fun closeMarket()
}