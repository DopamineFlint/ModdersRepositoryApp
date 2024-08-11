package ru.dpflint.moddersrepository.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class GameModelResponse(
    val name: String = "",
    @SerializedName("domain_name")
    val gameDomainName: String = "",
    val genre: String = "",
    val mods: Int = 0
)