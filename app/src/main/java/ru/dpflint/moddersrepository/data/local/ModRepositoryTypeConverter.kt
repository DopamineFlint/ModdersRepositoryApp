package ru.dpflint.moddersrepository.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.java.KoinJavaComponent.inject
import ru.dpflint.moddersrepository.data.local.dao.GameModelEntity

@ProvidedTypeConverter
class ModRepositoryTypeConverter() {

    private val gson by inject<Gson>(Gson::class.java)

    @TypeConverter
    fun fromSelectedGamesList(selectedGamesList: List<GameModelEntity>): String {
        return gson.toJson(selectedGamesList)
    }

    @TypeConverter
    fun toSelectedGamesList(selectedGamesList: String): List<GameModelEntity> {
        val listType = object : TypeToken<List<GameModelEntity>>() {}.type
        return gson.fromJson(selectedGamesList, listType)
    }
}