package ru.dpflint.moddersrepository.data.repository

import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.get
import ru.dpflint.moddersrepository.data.remote.ModsApi
import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.domain.repository.ModsRepository

class ModsRepositoryImpl(private val modsApi: ModsApi = get(ModsApi::class.java)) : ModsRepository, KoinComponent {

    override suspend fun getDataFromNexusMods(): List<GameModelResponse> {
        return modsApi.getNexusGamesList()
    }
}