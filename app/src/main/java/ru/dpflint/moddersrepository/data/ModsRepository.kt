package ru.dpflint.moddersrepository.data

import kotlinx.coroutines.delay
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.get
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.data.remote.ModsApi

class ModsRepository(private val apiClient: ModsApi = get(ModsApi::class.java)) : KoinComponent {
    suspend fun getDataFromNexusMods(): List<GameModel> {

        delay(4000)

        val response = apiClient.getNexusGamesList()
        val gamesList = response.body() ?: listOf()

        return gamesList
    }
}