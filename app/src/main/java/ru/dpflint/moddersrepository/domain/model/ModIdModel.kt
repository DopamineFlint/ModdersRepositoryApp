package ru.dpflint.moddersrepository.domain.model

import com.google.gson.annotations.SerializedName

data class ModIdModel(
    @SerializedName("mod_id")
    val modId: Int = 0,
    var gameDomainName: String = ""
)