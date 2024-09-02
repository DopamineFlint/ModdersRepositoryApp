package ru.dpflint.moddersrepository.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameModel(
    val name: String = "",
    val gameDomainName: String = "",
    val genre: String = "",
    val mods: Int = 0
) : Parcelable
