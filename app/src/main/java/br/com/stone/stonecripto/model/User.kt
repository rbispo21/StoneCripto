package br.com.stone.stonecripto.model

import io.realm.RealmList
import io.realm.RealmObject

open class User(var name: String? = null): RealmObject()