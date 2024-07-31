package ru.dpflint.moddersrepository.presentation.navigation

sealed class Screen(val route: String) {
    object GameSelectionScreen: Screen("game_selection_screen")
    object MainScreen: Screen("main_screen")
    object SettingsScreen: Screen("settings_screen")
}