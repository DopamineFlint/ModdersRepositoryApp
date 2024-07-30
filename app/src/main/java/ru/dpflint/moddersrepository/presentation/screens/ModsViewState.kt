package ru.dpflint.moddersrepository.presentation.screens

import ru.dpflint.moddersrepository.utils.test.GameModel

data class ModsViewState(
    val isLoading: Boolean = false,
    val games: List<GameModel> = emptyList(),
    val error: String? = null
)
