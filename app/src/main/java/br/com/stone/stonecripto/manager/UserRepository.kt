package br.com.stone.stonecripto.manager

interface UserRepository {
    fun saveName(name: String)
    fun clearUser()
    fun getUserName(): String
    fun hasUser(): Boolean
}