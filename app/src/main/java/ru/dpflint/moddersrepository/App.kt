package ru.dpflint.moddersrepository

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.dpflint.moddersrepository.di.appModule
import ru.dpflint.moddersrepository.di.databaseModule
import ru.dpflint.moddersrepository.di.repositoryModule
import ru.dpflint.moddersrepository.di.sharedPrefModule
import ru.dpflint.moddersrepository.di.useCasesModule
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@App)
            modules(
                sharedPrefModule,
                databaseModule,
                appModule,
                repositoryModule,
                useCasesModule
            )
        }
    }

}