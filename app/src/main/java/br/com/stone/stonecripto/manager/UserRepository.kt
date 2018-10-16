package br.com.stone.stonecripto.manager

import br.com.stone.stonecripto.model.CoinType

interface UserRepository {
    fun saveName(name: String)
    fun clearUser()
    fun getUserName(): String
    fun hasUser(): Boolean
}