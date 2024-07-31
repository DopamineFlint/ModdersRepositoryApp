package ru.dpflint.moddersrepository.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.dpflint.moddersrepository.presentation.navigation.SetupNavGraph
import ru.dpflint.moddersrepository.presentation.screens.game_selection.GameSelectionScreen
import ru.dpflint.moddersrepository.presentation.screens.main.MainScreen
import ru.dpflint.moddersrepository.presentation.ui.theme.ForTestsAndExercisesTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("CustomTag", "working")

        setContent {
            ForTestsAndExercisesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(18, 20, 23) //MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ForTestsAndExercisesTheme {
        MainScreen()
    }
}