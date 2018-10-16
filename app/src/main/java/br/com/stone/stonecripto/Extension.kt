package br.com.stone.stonecripto

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun Double.currencyString(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return formatter.format(BigDecimal(this))
}