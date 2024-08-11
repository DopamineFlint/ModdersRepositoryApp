package ru.dpflint.moddersrepository.data.repository

import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.get
import ru.dpflint.moddersrepository.data.local.ModsDao
import ru.dpflint.moddersrepository.data.local.dao.GameModelEntity
import ru.dpflint.moddersrepository.data.remote.ModsApi
import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.domain.model.ModDetailsModel
import ru.dpflint.moddersrepository.domain.model.ModIdModel
import ru.dpflint.moddersrepository.domain.repository.ModsRepository

class ModsRepositoryImpl(
    private val modsApi: ModsApi = get(ModsApi::class.java),
    private val modsDao: ModsDao = get(ModsDao::class.java)
) : ModsRepository, KoinComponent {
    override suspend fun getDataFromNexusMods(): List<GameModelResponse> {
        return modsApi.getNexusGamesList()
    }

    override suspend fun saveSelectedGamesIntoDatabase(data: List<GameModelEntity>) {
        return modsDao.insertSelectedGames(data)
    }

    override suspend fun getSavedGamesList(): List<GameModelEntity> {
        return modsDao.getSavedGamesList()
    }

    override suspend fun getUpdatedMods(gameDomainName: String): List<ModIdModel> {
        val updatedModsList = modsApi.getUpdatedMods(gameDomainName)
        updatedModsList.forEach {
            it.gameDomainName = gameDomainName //TODO неправильно мб
        }
        return updatedModsList
    }

    override suspend fun getModDetails(modId: Int, gameDomainName: String): ModDetailsModel {
        return modsApi.getModDetails(modId, gameDomainName)
    }
}