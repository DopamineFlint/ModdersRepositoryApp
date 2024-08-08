package ru.dpflint.moddersrepository.data.local

import androidx.room.ProvidedTypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.java.KoinJavaComponent.inject
import ru.dpflint.moddersrepository.data.local.dao.GameModelDao

@ProvidedTypeConverter
class ModRepositoryTypeConverter() {

    private val gson by inject<Gson>(Gson::class.java)

    fun fromSelectedGamesList(selectedGamesList: List<GameModelDao>): String {
        return gson.toJson(selectedGamesList)
    }

    fun toSelectedGamesList(selectedGamesList: String): List<GameModelDao> {
        val listType = object : TypeToken<List<GameModelDao>>() {}.type
        return gson.fromJson(selectedGamesList, listType)
    }
}