package ru.dpflint.moddersrepository.data.local.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_games_list")
data class GameModelDao(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?
)
