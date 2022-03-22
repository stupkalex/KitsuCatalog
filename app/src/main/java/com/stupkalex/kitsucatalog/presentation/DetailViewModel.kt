package com.stupkalex.kitsucatalog.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stupkalex.kitsucatalog.data.database.AppDatabase
import com.stupkalex.kitsucatalog.data.entity.Anime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val database = AppDatabase.getInstance(application)

    private val _animeItem = MutableLiveData<Anime>()
    val animeItem: LiveData<Anime>
        get() = _animeItem

    fun getAnimeItem(animeId: Int) {
        coroutineScope.launch {
            _animeItem.postValue(database.databaseDao().getAnimeItem(animeId))
        }
    }
}