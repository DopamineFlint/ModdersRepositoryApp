package ru.dpflint.moddersrepository.di

import org.koin.dsl.module
import ru.dpflint.moddersrepository.data.repository.ModsRepositoryImpl

val repositoryModule = module {

    single<ModsRepositoryImpl> {
        ModsRepositoryImpl()
    }
}