package br.com.stone.stonecripto.manager

import br.com.stone.stonecripto.model.User
import io.realm.Realm

class UserManager: UserRepository {
    override fun saveName(name: String) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            val user = User(name)
            realm.copyToRealm(user)
        }
    }

    override fun clearUser() {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            it.where(User::class.java).findAll().deleteAllFromRealm()
        }
    }

    override fun getUserName(): String {
        val realm = Realm.getDefaultInstance()
        val user = realm.where(User::class.java).findFirst()
        user?.name?.let {
            return it
        }
        return "Anônimo"
    }

    override fun hasUser(): Boolean {
        val realm = Realm.getDefaultInstance()
        val user = realm.where(User::class.java).findFirst()
        return user != null
    }

}