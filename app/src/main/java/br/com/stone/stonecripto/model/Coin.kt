package br.com.stone.stonecripto.model

import io.realm.RealmObject

open class Coin(var name: String? = null, var balance: Double? = 0.0,
                var priceBuy: Double? = 0.0, var priceSell: Double? = 0.0): RealmObject()