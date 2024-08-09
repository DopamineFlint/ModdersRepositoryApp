package ru.dpflint.moddersrepository.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameModel( //TODO какие методы есть у data class?
    val name: String = "",
    val genre: String = "",
    val mods: Int = 0
) : Parcelable
