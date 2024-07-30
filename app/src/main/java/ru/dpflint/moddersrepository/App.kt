package ru.dpflint.moddersrepository

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.dpflint.moddersrepository.di.appModule
import ru.dpflint.moddersrepository.di.repositoryModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                repositoryModule
            )
        }
    }

}