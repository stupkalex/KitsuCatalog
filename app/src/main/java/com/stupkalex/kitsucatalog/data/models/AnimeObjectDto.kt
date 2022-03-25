package com.stupkalex.kitsucatalog.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AnimeObjectDto(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("attributes")
    @Expose
    val attributesDto: AnimeAttributesDto
)
