package com.stupkalex.kitsucatalog.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AnimePosterImages(
    @SerializedName("small")
    @Expose
    val small: String,
    @SerializedName("original")
    @Expose
    val original: String
)