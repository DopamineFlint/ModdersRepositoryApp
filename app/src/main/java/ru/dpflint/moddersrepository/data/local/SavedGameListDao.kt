package ru.dpflint.moddersrepository.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.dpflint.moddersrepository.data.local.dao.GameModelDao

@Dao
interface SavedGamesListDao {
    @Query("SELECT * FROM saved_games_list")
    fun getSavedGamesList(): List<GameModelDao>

    @Insert
    fun insertSelectedGames(vararg games: GameModelDao)

    @Delete
    fun deleteSelectedGame(game: GameModelDao)
}