package ru.dpflint.moddersrepository.domain.repository

import ru.dpflint.moddersrepository.data.local.dao.GameModelEntity
import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.domain.model.ModDetailsModel
import ru.dpflint.moddersrepository.domain.model.ModIdModel

interface ModsRepository {
    suspend fun getDataFromNexusMods() : List<GameModelResponse>
    suspend fun saveSelectedGamesIntoDatabase(data: List<GameModelEntity>)
    suspend fun getSavedGamesList(): List<GameModelEntity>
    suspend fun getUpdatedMods(gameDomainName: String): List<ModIdModel>
    suspend fun getModDetails(modId: Int): ModDetailsModel
}