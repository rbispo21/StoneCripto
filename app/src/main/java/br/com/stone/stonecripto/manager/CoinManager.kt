package br.com.stone.stonecripto.manager

import br.com.stone.stonecripto.model.Coin
import br.com.stone.stonecripto.model.CoinType
import br.com.stone.stonecripto.model.Quotation
import io.realm.Realm

object CoinManager {
    fun addBalanceInitial(type: CoinType) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            val coin = realm.createObject(Coin::class.java)
            coin.name = type.name
            coin.balance = 100000.00
            realm.copyToRealm(coin)
        }
    }

    fun getBalance(type: CoinType): Double {
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name", type.name).findFirst()
        coin?.balance?.let {
            return it
        }
        return 0.0
    }

    fun updatePrice(type: CoinType, priceBuy: Double, priceSell: Double): Boolean {
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name", type.name).findFirst()
        coin?.let {itCoin ->
            realm.executeTransaction {
                itCoin.priceBuy = priceBuy
                itCoin.priceSell = priceSell
            }
            return true
        }

        realm.executeTransaction {
            val coinRealm = realm.createObject(Coin::class.java)
            coinRealm.name = type.name
            coinRealm.balance = 0.00
            coinRealm.priceBuy = priceBuy
            coinRealm.priceSell = priceSell
        }
        return true
    }

    fun buyCoin(type: CoinType, amount: Double): Boolean {
        if (hasBalance(type, amount)) {
            payment(type, amount)
            addCoin(type, amount)
            return true
        }else {
            return false
        }
    }

    fun sellCoin(type: CoinType, amount: Double): Boolean {
        val balance = getBalance(type)
        if (balance >= amount) {
            addCoin(CoinType.BRL, getPriceTotalSell(type, amount))
            sell(type, amount)
            return true
        } else {
            return false
        }
    }

    private fun hasBalance(type: CoinType, amount: Double): Boolean {
        val priceTotal = getPriceTotalBuy(type, amount)
        return if (priceTotal > 0) getBalance(CoinType.BRL) >= priceTotal else false
    }

    private fun payment(type: CoinType, amount: Double) {
        val priceTotal = getPriceTotalBuy(type, amount)
        val realm = Realm.getDefaultInstance()
        val coinBRL = realm.where(Coin::class.java).equalTo("name", CoinType.BRL.name).findFirst()
        coinBRL?.let {itCoinBRL ->
            itCoinBRL.balance?.let {itBalance ->
                realm.executeTransaction {
                    itCoinBRL.balance = itBalance - priceTotal
                }
            }
        }
    }

    private fun sell(type: CoinType, amount: Double) {
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name",type.name).findFirst()
        coin?.let { itCoin ->
            val priceSell = getPriceTotalSell(type, amount)
            itCoin.balance?.let {itCoinBalance ->
                realm.executeTransaction {
                    itCoin.balance = itCoinBalance - amount
                }
            }
        }
    }

    private fun addCoin(type: CoinType, amount: Double) {
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name", type.name).findFirst()
        coin?.let {itCoin ->
            itCoin.balance?.let {itBalance ->
                realm.executeTransaction {
                    itCoin.balance = itBalance + amount
                }
            }
        }
    }

    private fun getPriceTotalBuy(type: CoinType, amount: Double): Double{
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name", type.name).findFirst()
        coin?.priceBuy?.let {
            return amount * it
        }
        return 0.0
    }

    private fun getPriceTotalSell(type: CoinType, amount: Double): Double{
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name", type.name).findFirst()
        coin?.priceSell?.let {
            return amount * it
        }
        return 0.0
    }
}