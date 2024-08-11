package ru.dpflint.moddersrepository.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.dpflint.moddersrepository.data.remote.dto.response.GameModelResponse
import ru.dpflint.moddersrepository.domain.model.GameModel
import ru.dpflint.moddersrepository.domain.model.ModDetailsModel
import ru.dpflint.moddersrepository.domain.model.ModIdModel

interface ModsApi {

    @GET("v1/games.json")
    @Headers("apiKey: S8uO66RmQ4f0oGN2kZMsAwRgTvyGlFqATruTfJYavKk=--fWETAR+NInnmcD7K--Hvqh4siyaWzdrf4/HxkNhA==") //TODO
    suspend fun getNexusGamesList(): List<GameModelResponse>

    @GET("v1/games/{game_domain_name}/mods/updated.json?:period=1w") //TODO
    suspend fun getUpdatedMods(@Path("game_domain_name") gameDomainName: String): List<ModIdModel> //TODO

    @GET("v1/games/morrowind/mods/{id}.json")
    suspend fun getModDetails(@Path("id") modId: Int): ModDetailsModel
}