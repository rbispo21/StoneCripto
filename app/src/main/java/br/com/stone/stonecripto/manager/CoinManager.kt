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
}