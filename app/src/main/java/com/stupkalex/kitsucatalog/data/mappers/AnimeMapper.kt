package com.stupkalex.kitsucatalog.data.mappers

import com.stupkalex.kitsucatalog.data.database.AnimeDbModel
import com.stupkalex.kitsucatalog.domain.Anime

class AnimeMapper {

    fun mapDbModelToEntity(animeDbModel: AnimeDbModel) : Anime {
        return Anime(
            autoId = animeDbModel.autoId,
            id = animeDbModel.id,
            description = animeDbModel.description,
            title = animeDbModel.title,
            averageRating = animeDbModel.averageRating,
            startDate = animeDbModel.startDate,
            ageRatingGuide = animeDbModel.ageRatingGuide,
            ageRating = animeDbModel.ageRating,
            smallPoster = animeDbModel.smallPoster,
            bigPoster = animeDbModel.bigPoster,
            episodeCount = animeDbModel.episodeCount,
            youtubeVideoId = animeDbModel.youtubeVideoId
        )
    }
}