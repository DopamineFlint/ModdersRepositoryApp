package ru.dpflint.moddersrepository.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.dpflint.moddersrepository.data.local.dao.GameModelEntity

@Dao
interface ModsDao {
    @Query("SELECT * FROM saved_games_list")
    suspend fun getSavedGamesList(): List<GameModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSelectedGames(games: List<GameModelEntity>)

    @Delete
    suspend fun deleteSelectedGame(game: GameModelEntity)
}