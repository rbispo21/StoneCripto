package br.com.stone.stonecripto

import android.app.Application
import io.realm.Realm

class CustomApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}