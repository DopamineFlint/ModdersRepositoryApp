package ru.dpflint.moddersrepository.di

import androidx.room.Room
import org.koin.dsl.module
import ru.dpflint.moddersrepository.data.local.ModRepositoryDatabase

val databaseModule = module {
    single<ModRepositoryDatabase> {
        Room.databaseBuilder(
            context = get(),
            ModRepositoryDatabase::class.java,
            "mod_repository_db"
        )
            .fallbackToDestructiveMigration()
            //TODO .addTypeConverter()
            .build()
    }
}