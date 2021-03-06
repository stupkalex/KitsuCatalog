package com.stupkalex.kitsucatalog.data.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class AnimeAttributesDto(
    @SerializedName("description")
    @Expose
    val description: String? = null,
    @SerializedName("canonicalTitle")
    @Expose
    val canonicalTitle: String? = null,
    @SerializedName("averageRating")
    @Expose
    val averageRating: Double? = null,
    @SerializedName("startDate")
    @Expose
    val startDate: String? = null,
    @SerializedName("ageRatingGuide")
    @Expose
    val ageRatingGuide: String? = null,
    @SerializedName("posterImage")
    @Expose
    val posterImageDto: AnimePosterImagesDto? = null,
    @SerializedName("episodeCount")
    @Expose
    val episodeCount: Int = 0,
    @SerializedName("youtubeVideoId")
    @Expose
    val youtubeVideoId: String? = null,
    @SerializedName("ageRating")
    @Expose
    var ageRating: String? = null
)