package br.com.stone.stonecripto.manager

import android.content.Context
import android.content.Context.MODE_PRIVATE

class UserManager(val context: Context): UserRepository {
    private val PREFERENCES_USER = "user_preferences"
    private val PREFERENCES_USER_NAME = "user_preferences_name"

    override fun saveName(name: String) {
        val preferenceEditor = context.getSharedPreferences(PREFERENCES_USER, MODE_PRIVATE).edit()
        preferenceEditor.putString(PREFERENCES_USER_NAME, name)
        preferenceEditor.apply()
    }

    override fun clearUser() {
        val preferenceEditor = context.getSharedPreferences(PREFERENCES_USER, MODE_PRIVATE).edit()
        preferenceEditor.clear()
        preferenceEditor.apply()
    }

    override fun getUserName(): String {
        val preference = context.getSharedPreferences(PREFERENCES_USER, MODE_PRIVATE)
        return preference.getString(PREFERENCES_USER_NAME, "Anônimo")
    }

    override fun hasUser(): Boolean {
        val preference = context.getSharedPreferences(PREFERENCES_USER, MODE_PRIVATE)
        return preference.contains(PREFERENCES_USER_NAME)
    }

}