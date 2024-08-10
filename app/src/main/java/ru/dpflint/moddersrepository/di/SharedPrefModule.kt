package ru.dpflint.moddersrepository.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.dpflint.moddersrepository.data.local.SharedPrefUtil

val sharedPrefModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences("modders_repository_pref", Context.MODE_PRIVATE)
    }

    single<SharedPrefUtil> {
        SharedPrefUtil()
    }
}