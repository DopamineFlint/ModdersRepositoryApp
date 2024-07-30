package ru.dpflint.moddersrepository.data.mappers

import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.GameModel

fun GameModelResponse.toGameModel(): GameModel {
    return GameModel(
        name = name,
        genre = genre,
        mods = mods
    )
}