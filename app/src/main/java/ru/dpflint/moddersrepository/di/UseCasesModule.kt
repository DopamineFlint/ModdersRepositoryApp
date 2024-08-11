package ru.dpflint.moddersrepository.di

import org.koin.dsl.module
import ru.dpflint.moddersrepository.domain.usecase.GetDataFromNexusUseCase
import ru.dpflint.moddersrepository.domain.usecase.LoadSubscribedModsUseCase
import ru.dpflint.moddersrepository.domain.usecase.SaveSelectedGamesIntoDatabase

val useCasesModule = module {
    single<GetDataFromNexusUseCase> {
        GetDataFromNexusUseCase()
    }

    single<SaveSelectedGamesIntoDatabase> {
        SaveSelectedGamesIntoDatabase()
    }

    single<LoadSubscribedModsUseCase> {
        LoadSubscribedModsUseCase()
    }
}