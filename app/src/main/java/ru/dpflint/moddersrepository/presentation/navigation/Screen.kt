package ru.dpflint.moddersrepository.presentation.navigation

sealed class Screen(val route: String) {
    object GameSelectionScreen: Screen("game_selection_screen")
    object MainScreen: Screen("main_screen")
    object SettingsScreen: Screen("settings_screen")
    object GameListScreen: Screen("game_list_screen")
    object SelectedGameScreen: Screen("selected_game_screen")
}