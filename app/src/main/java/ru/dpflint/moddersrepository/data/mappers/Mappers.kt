package ru.dpflint.moddersrepository.data.mappers

import ru.dpflint.moddersrepository.data.local.dao.GameModelEntity
import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.NexusGameModel

fun GameModelResponse.toGameModel(): NexusGameModel {
    return NexusGameModel(
        name = name,
        gameDomainName = gameDomainName,
        genre = genre,
        mods = mods
    )
}

fun NexusGameModel.toGameModelEntity(): GameModelEntity {
    return GameModelEntity(
        name = name,
        gameDomainName = gameDomainName
    )
}