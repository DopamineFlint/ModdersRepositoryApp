package ru.dpflint.moddersrepository.presentation.screens.main

import ru.dpflint.moddersrepository.domain.model.NexusGameModel

sealed class ModsIntent {
    data object LoadGamesFromNexus : ModsIntent()
    data object LoadSubscribedGamesMods : ModsIntent()
    data class SaveSelectedGamesIntoDatabase(val data: List<NexusGameModel>) : ModsIntent()
}