package ru.dpflint.moddersrepository.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.dpflint.moddersrepository.presentation.navigation.Screen

@Composable
fun CustomBottomAppBar(
    navController: NavController
) {

    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Menu)
    }

    BottomAppBar(
        containerColor = Color.Gray
    ) {
        IconButton(
            onClick = {
                selected.value = Icons.Default.Menu
                navigationController.navigate(
                    Screen.MainScreen.route
                ) {
                    popUpTo(0) //TODO
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu"
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        IconButton(
            onClick = {
                selected.value = Icons.Default.Settings
                navigationController.navigate(
                    Screen.SettingsScreen.route
                ) {
                    popUpTo(0)
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings"
            )
        }
    }
}