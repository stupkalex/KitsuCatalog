package com.stupkalex.kitsucatalog.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stupkalex.kitsucatalog.data.entity.Anime

@Dao
interface DatabaseDao{

    @Query("SELECT * FROM anime_table")
    fun getAnimeList(): LiveData<List<Anime>>

    @Query("SELECT * FROM anime_table WHERE id == :animeId LIMIT 1")
    fun getAnimeItem(animeId: Int): Anime

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnime(anime: Anime)

    @Query("DELETE FROM anime_table")
    fun deleteAll()
}