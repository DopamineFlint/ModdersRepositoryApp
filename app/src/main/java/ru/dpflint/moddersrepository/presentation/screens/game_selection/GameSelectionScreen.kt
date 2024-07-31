package ru.dpflint.moddersrepository.presentation.screens.game_selection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.androidx.compose.koinViewModel
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.presentation.components.CustomTopBar
import ru.dpflint.moddersrepository.presentation.screens.main.ErrorMessage
import ru.dpflint.moddersrepository.presentation.screens.main.GamesList
import ru.dpflint.moddersrepository.presentation.screens.main.LoadingBar
import ru.dpflint.moddersrepository.presentation.screens.main.ModsIntent
import ru.dpflint.moddersrepository.presentation.viewmodel.MainViewModel

@Composable
fun GameSelectionScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopBar(title = "Select Game")
        },
        containerColor = MaterialTheme.colorScheme.onPrimary
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Text", color = Color.White)
        }
    }

    //val state by viewModel.state.collectAsState()

//    LaunchedEffect(key1 = true) {
//        viewModel.handleIntent(
//            intent = ModsIntent.LoadGamesFromNexus
//        )
//    }

//    when {
//        state.isLoading -> {
//            LoadingBar()
//        }
//        state.error != null -> {
//            ErrorMessage(state.error)
//        }
//        else -> {
//            GameSelectionList(
//                gamesList = state.games
//            )
//        }
//    }
}

@Composable
private fun GameSelectionList(
    gamesList: List<GameModel>
) {
    LazyColumn(

    ) {

    }
}