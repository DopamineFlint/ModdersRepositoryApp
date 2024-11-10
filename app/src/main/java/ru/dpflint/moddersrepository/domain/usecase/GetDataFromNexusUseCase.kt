package ru.dpflint.moddersrepository.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.java.KoinJavaComponent.inject
import ru.dpflint.moddersrepository.data.mappers.toGameModel
import ru.dpflint.moddersrepository.domain.model.NexusGameModel
import ru.dpflint.moddersrepository.domain.repository.ModsRepository
import ru.dpflint.moddersrepository.utils.Resource

class GetDataFromNexusUseCase {

    private val modsRepository by inject<ModsRepository>(ModsRepository::class.java)

    suspend fun getDataFromNexusMods(): Flow<Resource<List<NexusGameModel>>> = flow {

        //delay(4000)
        emit(Resource.Loading())

        try {
            val response = modsRepository.getDataFromNexusMods()
            val gamesList: List<NexusGameModel> = response.map {
                it.toGameModel()
            }

            emit(Resource.Success(data = gamesList))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage))
        }
    }
}