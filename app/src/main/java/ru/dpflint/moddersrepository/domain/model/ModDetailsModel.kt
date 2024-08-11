package ru.dpflint.moddersrepository.domain.model

import com.google.gson.annotations.SerializedName

data class ModDetailsModel(
    val name: String,
    @SerializedName("picture_url")
    val pictureURL: String
)