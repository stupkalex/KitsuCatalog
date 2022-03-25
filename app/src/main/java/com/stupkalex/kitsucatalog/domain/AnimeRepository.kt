package com.stupkalex.kitsucatalog.domain

import androidx.lifecycle.LiveData

interface AnimeRepository {

    fun getAnimeList(): LiveData<List<Anime>>

    fun getAnime(animeId: Int): LiveData<Anime>

    suspend fun loadData(offset: Int)

    fun deleteAnime()
}