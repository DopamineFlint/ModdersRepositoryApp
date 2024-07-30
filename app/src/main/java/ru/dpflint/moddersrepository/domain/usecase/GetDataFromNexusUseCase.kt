package ru.dpflint.moddersrepository.domain.usecase

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.get
import ru.dpflint.moddersrepository.data.mappers.toGameModel
import ru.dpflint.moddersrepository.data.remote.ModsApi
import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.domain.repository.ModsRepository
import ru.dpflint.moddersrepository.utils.Resource

class GetDataFromNexusUseCase(private val modsRepository: ModsRepository = get(ModsRepository::class.java)) : KoinComponent { //TODO
    suspend fun getDataFromNexusMods(): Flow<Resource<List<GameModel>>> = flow { //TODO FLOW

        //delay(4000)
        emit(Resource.Loading())

        try {
            val response = modsRepository.getDataFromNexusMods()
            val gamesList: List<GameModel> = response.map {
                it.toGameModel()
            }

            emit(Resource.Success(data = gamesList))
        } catch (e: Exception) {

        }
    }
}