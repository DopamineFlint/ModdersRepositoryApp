package ru.dpflint.moddersrepository.presentation.screens

import android.graphics.drawable.shapes.Shape
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ru.dpflint.moddersrepository.presentation.screens.viewmodels.MainViewModel
import ru.dpflint.moddersrepository.utils.test.GameModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val disposableKey = remember { mutableStateOf(false) }
    val gamesList = remember { mutableStateOf(listOf<GameModel>()) }

    val columnState = rememberLazyListState()

    LaunchedEffect(key1 = true) {
        viewModel.handleIntent(
            intent = ModsIntent.LoadGamesFromNexus
        )
    }

    when {
        state.isLoading -> {
            LoadingBar()
        }
        state.error != null -> {
            ErrorMessage(state.error)
        }
        else -> {
            GamesList(
                gamesList = state.games
            )
        }
    }
}

@Composable
fun GamesList(
    gamesList: List<GameModel>
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        )
    ) {
        items(if (gamesList.isEmpty()) 0 else 20) { index ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(18, 20, 23)),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(),
            ) {
                Text(
                    text = gamesList[index].name,
                    color = Color.White
                )
                Text(
                    text = gamesList[index].genre,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun LoadingBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Loading...", color = Color.White)
    }
}

@Composable
fun ErrorMessage(
    errorMessage: String?
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = errorMessage ?: "Just error", color = Color.White)
    }
}

