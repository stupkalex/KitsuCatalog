package com.stupkalex.kitsucatalog.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "anime_table", indices = [Index(value = ["id"], unique = true)])
data class Anime(
    @PrimaryKey(autoGenerate = true)
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
