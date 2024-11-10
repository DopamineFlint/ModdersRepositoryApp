package ru.dpflint.moddersrepository.presentation.screens.main

import ru.dpflint.moddersrepository.domain.model.NexusGameModel
import ru.dpflint.moddersrepository.domain.model.ModDetailsModel

data class ModsViewState(
    val isLoading: Boolean = false,
    val games: List<NexusGameModel> = emptyList(),
    val mods: List<ModDetailsModel> = emptyList(),
    val error: String? = null,
    val isSelectedGamesSavedSuccessfully: Boolean = false
)
