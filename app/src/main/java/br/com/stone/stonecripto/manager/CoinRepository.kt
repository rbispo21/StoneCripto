package br.com.stone.stonecripto.manager

import br.com.stone.stonecripto.model.CoinType
import br.com.stone.stonecripto.model.Transaction
import io.realm.RealmResults

interface CoinRepository {
    fun addBalanceInitial(type: CoinType)
    fun getBalance(type: CoinType): Double
    fun updatePrice(type: CoinType, priceBuy: Double, priceSell: Double): Boolean
    fun buyCoin(type: CoinType, amount: Double): Boolean
    fun sellCoin(type: CoinType, amount: Double): Boolean
    fun getAllTransaction(): RealmResults<Transaction>
}