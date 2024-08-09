package ru.dpflint.moddersrepository.di

import android.content.Context
import androidx.room.Room
import org.koin.dsl.module
import ru.dpflint.moddersrepository.data.local.ModRepositoryDatabase
import ru.dpflint.moddersrepository.data.local.ModsDao

val databaseModule = module {
    single<ModRepositoryDatabase> {
        Room.databaseBuilder(
            context = get<Context>(),
            ModRepositoryDatabase::class.java,
            "mod_repository_db"
        )
            .fallbackToDestructiveMigration()
            //TODO .addTypeConverter()
            .build()
    }

    single<ModsDao> {
        get<ModRepositoryDatabase>().getSavedGamesListDao()
    }
}