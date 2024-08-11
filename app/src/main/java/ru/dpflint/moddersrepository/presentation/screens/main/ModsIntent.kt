package ru.dpflint.moddersrepository.presentation.screens.main

import ru.dpflint.moddersrepository.domain.model.GameModel

sealed class ModsIntent {
    data object LoadGamesFromNexus : ModsIntent()
    data object LoadSubscribedGamesMods : ModsIntent()
    data class SaveSelectedGamesIntoDatabase(val data: List<GameModel>) : ModsIntent()
}