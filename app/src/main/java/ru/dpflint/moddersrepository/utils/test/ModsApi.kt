package ru.dpflint.moddersrepository.utils.test

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ModsApi {
    @GET("v1/games.json")
    @Headers("apiKey: S8uO66RmQ4f0oGN2kZMsAwRgTvyGlFqATruTfJYavKk=--fWETAR+NInnmcD7K--Hvqh4siyaWzdrf4/HxkNhA==") //TODO
    suspend fun getNexusGamesList(): Response<List<GameModel>>
}