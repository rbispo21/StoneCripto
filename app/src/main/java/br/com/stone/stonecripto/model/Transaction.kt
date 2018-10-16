package br.com.stone.stonecripto.model

import io.realm.RealmObject
import java.util.*

data class Transaction(var type: String?, var typeCoin: String?, var amount: Double?,
                       var priceTotal: Double?, var date: Date?): RealmObject()