package ru.dpflint.moddersrepository.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.dpflint.moddersrepository.presentation.screens.SelectedGameScreen
import ru.dpflint.moddersrepository.presentation.screens.game_list.GameListScreen
import ru.dpflint.moddersrepository.presentation.screens.game_selection.GameSelectionScreen
import ru.dpflint.moddersrepository.presentation.screens.main.MainScreen
import ru.dpflint.moddersrepository.presentation.screens.settings.SettingsScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.GameListScreen.route
    ) {
        composable(
            route = Screen.GameSelectionScreen.route
        ) {
            GameSelectionScreen(navController = navController)
        }
        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.SettingsScreen.route
        ) {
            SettingsScreen(navController = navController)
        }
        composable(
            route = Screen.GameListScreen.route
        ) {
            GameListScreen(navController = navController)
        }
        composable(
            route = Screen.SelectedGameScreen.route
        ) {
            SelectedGameScreen(navController = navController)
        }
    }
}