package com.stupkalex.kitsucatalog.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AnimeListOfDataDto(
    @SerializedName("data")
    @Expose
    val data : List<AnimeObjectDto>
)


