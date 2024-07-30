package ru.dpflint.moddersrepository.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.dpflint.moddersrepository.BuildConfig
import ru.dpflint.moddersrepository.presentation.viewmodel.MainViewModel
import ru.dpflint.moddersrepository.data.remote.ModsApi
import ru.dpflint.moddersrepository.domain.usecase.GetDataFromNexusUseCase

val appModule = module {
    single<Retrofit> {
        val nexusModsUrl = "https://api.nexusmods.com/"

        Retrofit.Builder()
            .baseUrl(nexusModsUrl)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ModsApi> {
        get<Retrofit>().create(ModsApi::class.java)
    }

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                this.level = HttpLoggingInterceptor.Level.BODY
            } else {
                this.level = HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single<GetDataFromNexusUseCase> {
        GetDataFromNexusUseCase()
    }

    viewModel {
        MainViewModel()
    }
}