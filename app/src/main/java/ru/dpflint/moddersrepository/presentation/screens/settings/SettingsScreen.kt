package ru.dpflint.moddersrepository.presentation.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.dpflint.moddersrepository.presentation.components.CustomBottomAppBar
import ru.dpflint.moddersrepository.presentation.components.CustomTopBar
import ru.dpflint.moddersrepository.presentation.navigation.Screen
import ru.dpflint.moddersrepository.presentation.screens.main.ErrorMessage
import ru.dpflint.moddersrepository.presentation.screens.main.GamesList
import ru.dpflint.moddersrepository.presentation.screens.main.LoadingBar

@Composable
fun SettingsScreen(
    navController: NavController
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            CustomBottomAppBar(
                navController = navController
            )
        },
        containerColor = MaterialTheme.colorScheme.onPrimary
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Settings Screen"
            )
        }
    }
}