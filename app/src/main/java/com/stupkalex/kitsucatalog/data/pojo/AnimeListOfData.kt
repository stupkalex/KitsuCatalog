package com.stupkalex.kitsucatalog.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AnimeListOfData(
    @SerializedName("data")
    @Expose
    val data : List<AnimeObject>
)


