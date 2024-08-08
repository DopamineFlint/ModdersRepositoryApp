package ru.dpflint.moddersrepository.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        SavedGamesListDao::class
    ],
    exportSchema = false,
    version = 7
)
abstract class ModRepositoryDatabase : RoomDatabase() {

    abstract fun getSavedGamesListDao() : SavedGamesListDao
}