package com.stupkalex.kitsucatalog.data.network

import com.stupkalex.kitsucatalog.data.models.AnimeListOfDataDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("anime")
    suspend fun getAnime(
        @Query(QUERY_PARAM_PAGE_LIMIT) limit: Int,
        @Query(QUERY_PARAM_PAGE_OFFSET) offset: Int,
        @Query(QUERY_PARAM_SORT_BY) sort: String
    ): AnimeListOfDataDto


    companion object {
        private const val QUERY_PARAM_PAGE_LIMIT = "page[limit]"
        private const val QUERY_PARAM_PAGE_OFFSET = "page[offset]"
        private const val QUERY_PARAM_SORT_BY = "sort"
    }
}