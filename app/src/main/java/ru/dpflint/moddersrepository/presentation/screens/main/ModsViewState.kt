package ru.dpflint.moddersrepository.presentation.screens.main

import ru.dpflint.moddersrepository.domain.model.GameModel

data class ModsViewState(
    val isLoading: Boolean = false,
    val games: List<GameModel> = emptyList(),
    val error: String? = null
)
