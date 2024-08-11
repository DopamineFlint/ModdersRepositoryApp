package ru.dpflint.moddersrepository.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.compose.koinInject
import org.koin.java.KoinJavaComponent.inject
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.domain.model.ModDetailsModel
import ru.dpflint.moddersrepository.domain.model.ModIdModel
import ru.dpflint.moddersrepository.domain.repository.ModsRepository
import ru.dpflint.moddersrepository.utils.Resource

class LoadSubscribedModsUseCase() {

    private val modsRepository by inject<ModsRepository>(ModsRepository::class.java) //TODO

    suspend fun loadSubscribedMods(): Flow<Resource<List<ModDetailsModel>>> = flow {
        try {
            emit(Resource.Loading())
            val modsList = arrayListOf<ModDetailsModel>()
            val listOfUpdatedMods = arrayListOf<ModIdModel>()
            val savedData = modsRepository.getSavedGamesList()

            for (item in savedData) {
                 listOfUpdatedMods.addAll(modsRepository.getUpdatedMods(item.name ?: "")) //modsRepository.getUpdatedMods()
            }

            for (item in listOfUpdatedMods) {
                modsList.add(modsRepository.getModDetails(item.modId))
            }

            emit(Resource.Success(modsList))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }
}