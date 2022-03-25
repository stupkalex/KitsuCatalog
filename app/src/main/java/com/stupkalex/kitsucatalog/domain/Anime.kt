package com.stupkalex.kitsucatalog.domain

data class Anime(
    val autoId: Int = 0,
    var id: Int = 0,
    var description: String? = null,
    var title: String? = null,
    var averageRating: Double? = null,
    var startDate: String? = null,
    var ageRatingGuide: String? = null,
    var ageRating: String? = null,
    var smallPoster: String? = null,
    var bigPoster: String? = null,
    var episodeCount: Int = 0,
    var youtubeVideoId: String? = null
)