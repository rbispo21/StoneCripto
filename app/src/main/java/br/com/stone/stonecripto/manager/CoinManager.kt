package br.com.stone.stonecripto.manager

import br.com.stone.stonecripto.model.Coin
import br.com.stone.stonecripto.model.CoinType
import io.realm.Realm

class CoinManager {
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

    fun updatePrice(type: CoinType, price: Double): Boolean {
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name", type.name).findFirst()
        coin?.let {itCoint ->
            realm.executeTransaction {
                itCoint.price = price
            }
            return true
        }

        realm.executeTransaction {
            val coinRealm = realm.createObject(Coin::class.java)
            coinRealm.name = type.name
            coinRealm.balance = 0.00
            coinRealm.price = price
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

    private fun hasBalance(type: CoinType, amount: Double): Boolean {
        val priceTotal = getPriceTotal(type, amount)
        return if (priceTotal > 0) getBalance(CoinType.BRL) >= priceTotal else false
    }

    private fun payment(type: CoinType, amount: Double) {
        val priceTotal = getPriceTotal(type, amount)
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

    private fun getPriceTotal(type: CoinType, amount: Double): Double{
        val realm = Realm.getDefaultInstance()
        val coin = realm.where(Coin::class.java).equalTo("name", type.name).findFirst()
        coin?.price?.let {
            return amount * it
        }
        return 0.0
    }
}