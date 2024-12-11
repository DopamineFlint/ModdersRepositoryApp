package ru.dpflint.moddersrepository.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.dpflint.moddersrepository.presentation.viewmodel.MainViewModel
import ru.dpflint.moddersrepository.domain.model.ModDetailsModel
import ru.dpflint.moddersrepository.presentation.components.CustomBottomAppBar
import ru.dpflint.moddersrepository.presentation.components.CustomTopBar
import timber.log.Timber

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    val verticalGridState = rememberLazyGridState()
    var isMethodCalled by rememberSaveable { mutableStateOf(false) }

    Timber.tag("MainScreenCalledLog").d("MAIN SCREEN CALLED")

    LaunchedEffect(key1 = true) {
        if (!isMethodCalled) {
            viewModel.handleIntent(
                intent = ModsIntent.LoadSubscribedGamesMods
            )
            isMethodCalled = true
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopBar(
                title = "Games list",
                enableDoneButton = false,
                enableSearchButton = true,
                onClick = {

                }
            )
        },
        bottomBar = {
            CustomBottomAppBar(
                navController = navController
            ) {

            }
        },
        containerColor = MaterialTheme.colorScheme.onPrimary
    ) { padding ->
        when {
            state.isLoading -> {
                LoadingBar()
            }
            state.error != null -> {
                ErrorMessage(state.error)
            }
            else -> {
                if (state.mods.isNotEmpty()) {
                    Timber.tag("IsNotEmptyLog").d("PASSED")
                    Timber.tag("IsNotEmptyLog").d(state.mods.isNotEmpty().toString())
                    Timber.tag("IsNotEmptyLog").d(state.mods.size.toString())
                    Timber.tag("IsNotEmptyLog").d(state.mods.toString())
                    ModsList(
                        modsList = state.mods,
                        paddingValues = padding,
                        state = verticalGridState
                    )
                }
            }
        }
    }
}

@Composable
fun ModsList(
    state: LazyGridState,
    modsList: List<ModDetailsModel>,
    paddingValues: PaddingValues
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        state = state
    ) {
        items(20) { index ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(18, 20, 23)),
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.elevatedCardElevation(),
            ) {
                Text(
                    text = modsList[index].name ?: "UNKNOWN",
                    color = Color.White
                )
                Text(
                    text = modsList[index].pictureURL ?: "UNKNOWN",
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

