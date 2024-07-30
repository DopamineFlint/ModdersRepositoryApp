package ru.dpflint.moddersrepository.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.dpflint.moddersrepository.data.repository.ModsRepository
import ru.dpflint.moddersrepository.presentation.screens.main.ModsIntent
import ru.dpflint.moddersrepository.presentation.screens.main.ModsViewState

class MainViewModel(private val modsRepository: ModsRepository) : ViewModel() {
    private val _state = MutableStateFlow(ModsViewState())
    val state: StateFlow<ModsViewState> = _state //TODO что такое Flow, StateFlow и SharedFlow

    fun handleIntent(intent: ModsIntent) {
        viewModelScope.launch { //TODO для чего нужен viewModelScope?
            when (intent) {
                ModsIntent.LoadGamesFromNexus -> {
                    loadModsFromNexus()
                }
                else -> {}
            }
        }
    }

    private suspend fun loadModsFromNexus() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        try {
            val games = modsRepository.getDataFromNexusMods()
            _state.value = ModsViewState(isLoading = false, games = games, error = null)
        } catch(e: Exception) {
            _state.value =
                ModsViewState(isLoading = false, error = e.message ?: "Error fetching data from Nexus")
        }
    }
}