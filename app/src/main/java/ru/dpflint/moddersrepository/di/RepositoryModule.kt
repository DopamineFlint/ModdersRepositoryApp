package ru.dpflint.moddersrepository.di

import org.koin.dsl.module
import ru.dpflint.moddersrepository.data.repository.ModsRepositoryImpl
import ru.dpflint.moddersrepository.domain.repository.ModsRepository

val repositoryModule = module { //TODO
    single<ModsRepositoryImpl> {
        ModsRepositoryImpl()
    }
    single<ModsRepository> {
        ModsRepositoryImpl()
    }
}