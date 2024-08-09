package ru.dpflint.moddersrepository.domain.repository

import ru.dpflint.moddersrepository.data.local.dao.GameModelEntity
import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.GameModel

interface ModsRepository {
    suspend fun getDataFromNexusMods() : List<GameModelResponse>

    suspend fun saveSelectedGamesIntoDatabase(data: List<GameModelEntity>)
}