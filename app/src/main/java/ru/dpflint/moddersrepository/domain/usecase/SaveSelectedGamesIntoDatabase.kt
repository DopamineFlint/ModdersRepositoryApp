package ru.dpflint.moddersrepository.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.java.KoinJavaComponent.inject
import ru.dpflint.moddersrepository.data.mappers.toGameModelEntity
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.domain.repository.ModsRepository
import ru.dpflint.moddersrepository.utils.Resource

class SaveSelectedGamesIntoDatabase {

    private val modsRepository by inject<ModsRepository>(ModsRepository::class.java)

    fun saveData(data: List<GameModel>): Flow<Resource<Unit>> = flow {
        try {
            emit(Resource.Loading())

            val gameModelEntityList = data.map {
                it.toGameModelEntity()
            }

            val result = modsRepository.saveSelectedGamesIntoDatabase(gameModelEntityList)
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unable to save selected games. Please, try again."))
        }
    }
}