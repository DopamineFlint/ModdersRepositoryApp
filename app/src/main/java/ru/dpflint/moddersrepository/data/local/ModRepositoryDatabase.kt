package ru.dpflint.moddersrepository.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.dpflint.moddersrepository.data.local.dao.GameModelEntity

@Database(
    entities = [
        GameModelEntity::class
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(ModRepositoryTypeConverter::class)
abstract class ModRepositoryDatabase : RoomDatabase() {

    abstract fun getSavedGamesListDao() : SavedGamesListDao
}