package br.com.stone.stonecripto.manager

import android.content.Context
import android.content.Context.MODE_PRIVATE

class UserManager(val context: Context) {
    private val PREFERENCES_USER = "user_preferences"
    private val PREFERENCES_USER_NAME = "user_preferences_name"

    fun saveNameUser(name: String) {
        val preferenceEditor = context.getSharedPreferences(PREFERENCES_USER, MODE_PRIVATE).edit()
        preferenceEditor.putString(PREFERENCES_USER_NAME, name)
        preferenceEditor.apply()
    }

    fun clearUser() {
        val preferenceEditor = context.getSharedPreferences(PREFERENCES_USER, MODE_PRIVATE).edit()
        preferenceEditor.clear()
        preferenceEditor.apply()
    }

    fun getUserName(): String {
        val preference = context.getSharedPreferences(PREFERENCES_USER, MODE_PRIVATE)
        return preference.getString(PREFERENCES_USER_NAME, "Anônimo")
    }

}