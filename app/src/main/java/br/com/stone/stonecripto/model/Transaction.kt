package br.com.stone.stonecripto.model

import io.realm.RealmObject
import java.util.*

open class Transaction(var type: String? = null, var typeCoin: String? = null, var amount: Double? = 0.0,
                       var priceTotal: Double? = 0.0, var date: Date? = Date()): RealmObject()