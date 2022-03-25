package com.stupkalex.kitsucatalog.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AnimePosterImagesDto(
    @SerializedName("small")
    @Expose
    val small: String,
    @SerializedName("original")
    @Expose
    val original: String
)