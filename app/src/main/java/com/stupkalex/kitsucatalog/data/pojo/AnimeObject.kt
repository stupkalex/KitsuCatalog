package com.stupkalex.kitsucatalog.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AnimeObject(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("attributes")
    @Expose
    val attributes: AnimeAttributes
)
