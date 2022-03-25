package com.stupkalex.kitsucatalog.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DatabaseDao{

    @Query("SELECT * FROM anime_table")
    fun getAnimeList(): LiveData<List<AnimeDbModel>>

    @Query("SELECT * FROM anime_table WHERE id == :animeId LIMIT 1")
    fun getAnimeItem(animeId: Int): LiveData<AnimeDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime(animeDbModel: AnimeDbModel)

    @Query("DELETE FROM anime_table")
    fun deleteAll()
}