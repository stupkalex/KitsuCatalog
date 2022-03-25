package com.stupkalex.kitsucatalog.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stupkalex.kitsucatalog.data.database.AppDatabase
import com.stupkalex.kitsucatalog.data.database.AnimeDbModel
import com.stupkalex.kitsucatalog.data.database.repository.AnimeRepositoryImpl
import com.stupkalex.kitsucatalog.domain.Anime
import com.stupkalex.kitsucatalog.domain.GetAnimeUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AnimeRepositoryImpl(application)

    private val getAnimeUseCase = GetAnimeUseCase(repository)

    fun getAnimeItem(animeId: Int) = getAnimeUseCase(animeId)
}