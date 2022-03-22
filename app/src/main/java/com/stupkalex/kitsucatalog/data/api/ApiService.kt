package com.stupkalex.kitsucatalog.data.api

import com.stupkalex.kitsucatalog.data.pojo.AnimeListOfData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("anime")
    fun getAnime(
        @Query(QUERY_PARAM_PAGE_LIMIT) limit: Int,
        @Query(QUERY_PARAM_PAGE_OFFSET) offset: Int,
        @Query(QUERY_PARAM_SORT_BY) sort: String
    ): Single<AnimeListOfData>


    companion object {
        private const val QUERY_PARAM_PAGE_LIMIT = "page[limit]"
        private const val QUERY_PARAM_PAGE_OFFSET = "page[offset]"
        private const val QUERY_PARAM_SORT_BY = "sort"
    }
}