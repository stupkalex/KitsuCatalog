package com.stupkalex.kitsucatalog.data.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.stupkalex.kitsucatalog.data.database.AnimeDbModel
import com.stupkalex.kitsucatalog.data.database.AppDatabase
import com.stupkalex.kitsucatalog.data.mappers.AnimeMapper
import com.stupkalex.kitsucatalog.data.network.ApiFactory
import com.stupkalex.kitsucatalog.domain.Anime
import com.stupkalex.kitsucatalog.domain.AnimeRepository

class AnimeRepositoryImpl(private val application: Application) : AnimeRepository {

    private val database = AppDatabase.getInstance(application)
    private val mapper = AnimeMapper()
    private val apiService = ApiFactory.apiService


    override fun getAnimeList(): LiveData<List<Anime>> {
        return Transformations.map(database.databaseDao().getAnimeList()) {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getAnime(animeId: Int): LiveData<Anime> {
        return Transformations.map(database.databaseDao().getAnimeItem(animeId)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData(offset: Int) {
        val animeListOfData = apiService.getAnime(LIMIT_PAGE, offset, SORT_BY)
        val listAnimeObject = animeListOfData.data
        for (i in listAnimeObject.indices) {
            val itemAnime = AnimeDbModel(
                id = listAnimeObject[i].id,
                title = listAnimeObject[i].attributesDto.canonicalTitle,
                averageRating = listAnimeObject[i].attributesDto.averageRating,
                ageRatingGuide = listAnimeObject[i].attributesDto.ageRatingGuide,
                startDate = listAnimeObject[i].attributesDto.startDate,
                episodeCount = listAnimeObject[i].attributesDto.episodeCount,
                description = listAnimeObject[i].attributesDto.description,
                youtubeVideoId = listAnimeObject[i].attributesDto.youtubeVideoId,
                smallPoster = listAnimeObject[i].attributesDto.posterImageDto?.small,
                bigPoster = listAnimeObject[i].attributesDto.posterImageDto?.original,
                ageRating = listAnimeObject[i].attributesDto.ageRating
            )
            database.databaseDao().insertAnime(itemAnime)
        }
    }

    override fun deleteAnime() {
        database.databaseDao().deleteAll()
    }

    companion object {
        private const val LIMIT_PAGE = 20
        private const val OFFSET_PAGE = 0

        // private const val SORT_BY = "-averageRating"
        private const val SORT_BY = "-userCount"
    }
}