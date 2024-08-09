package ru.dpflint.moddersrepository.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.dpflint.moddersrepository.domain.usecase.GetDataFromNexusUseCase
import ru.dpflint.moddersrepository.presentation.screens.main.ModsIntent
import ru.dpflint.moddersrepository.presentation.screens.main.ModsViewState
import ru.dpflint.moddersrepository.utils.Resource

class MainViewModel() : ViewModel() { //TODO

    private val getDataFromNexusUseCase by inject<GetDataFromNexusUseCase>(GetDataFromNexusUseCase::class.java)

    private val _state = MutableStateFlow(ModsViewState())
    val state: StateFlow<ModsViewState> = _state //TODO что такое Flow, StateFlow и SharedFlow

    fun handleIntent(intent: ModsIntent) {
        viewModelScope.launch { //TODO для чего нужен viewModelScope?
            when (intent) {
                ModsIntent.LoadGamesFromNexus -> {
                    if (_state.value.games.isEmpty()) { //TODO проверяем кэш, что бы устранить перезагрузку при повороте экрана, если контент есть
                        loadModsFromNexus()
                    } else {
                        return@launch
                    }
                }
                else -> {}
            }
        }
    }

    private suspend fun loadModsFromNexus() {
        getDataFromNexusUseCase.getDataFromNexusMods().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true, error = null)
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(isLoading = false, error = result.message)
                }
                is Resource.Success -> {
                    _state.value = _state.value.copy(isLoading = false, error = null, games = result.data!!) //TODO result.data!!
                }
                else -> {}
            }
        }.launchIn(viewModelScope)
    }
}