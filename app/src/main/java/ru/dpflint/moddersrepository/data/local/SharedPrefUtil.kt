package ru.dpflint.moddersrepository.data.local

import android.content.SharedPreferences
import org.koin.java.KoinJavaComponent.inject

class SharedPrefUtil {

    private val sharedPreferences by inject<SharedPreferences>(SharedPreferences::class.java)

    fun isFirstAppLaunch(): Boolean {
        return sharedPreferences.getBoolean("IS_FIRST_APP_LAUNCH", true)
    }

    fun saveFirstAppLaunch(value: Boolean) {
        sharedPreferences.edit().putBoolean("IS_FIRST_APP_LAUNCH", value).apply()
    }
}