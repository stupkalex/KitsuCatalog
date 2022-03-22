package com.stupkalex.kitsucatalog.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.stupkalex.kitsucatalog.data.api.ApiFactory
import com.stupkalex.kitsucatalog.data.database.AppDatabase
import com.stupkalex.kitsucatalog.data.entity.Anime
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CatalogViewModel (application: Application) : AndroidViewModel(application) {

    var offsetCount = OFFSET_PAGE
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val database = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val listAnime = database.databaseDao().getAnimeList()

    fun loadData(offset: Int) {
        val disposable = ApiFactory.apiService.getAnime(LIMIT_PAGE, offset, SORT_BY)
            .map { it.data }
            .subscribeOn(Schedulers.io())
            .subscribe({
                /*if(offsetCount == LIMIT_PAGE){
                    clearDatabase()
                }*/
                for (i in it.indices) {
                    val itemAnime = Anime(
                        id = it[i].id,
                        title = it[i].attributes.canonicalTitle,
                        averageRating = it[i].attributes.averageRating,
                        ageRatingGuide = it[i].attributes.ageRatingGuide,
                        startDate = it[i].attributes.startDate,
                        episodeCount = it[i].attributes.episodeCount,
                        description = it[i].attributes.description,
                        youtubeVideoId = it[i].attributes.youtubeVideoId,
                        smallPoster = it[i].attributes.posterImage?.small,
                        bigPoster =  it[i].attributes.posterImage?.original,
                        ageRating = it[i].attributes.ageRating
                    )
                    database.databaseDao().insertAnime(itemAnime)
                    offsetCount += LIMIT_PAGE
                }
            }, {
                Log.d("TEST_TO_LOADING_DATA", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    init {
        loadData(OFFSET_PAGE)
    }

    fun clearDatabase(){
        coroutineScope.launch {
            database.databaseDao().deleteAll()
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    companion object {
        private const val LIMIT_PAGE = 20
        private const val OFFSET_PAGE = 0
            // private const val SORT_BY = "-averageRating"
        private const val SORT_BY = "-userCount"
    }
}