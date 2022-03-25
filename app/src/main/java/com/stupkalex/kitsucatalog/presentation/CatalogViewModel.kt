package com.stupkalex.kitsucatalog.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.stupkalex.kitsucatalog.data.database.AppDatabase
import com.stupkalex.kitsucatalog.data.database.repository.AnimeRepositoryImpl
import com.stupkalex.kitsucatalog.domain.DeleteAnimeUseCase
import com.stupkalex.kitsucatalog.domain.GetAnimeListUseCase
import com.stupkalex.kitsucatalog.domain.GetAnimeUseCase
import com.stupkalex.kitsucatalog.domain.LoadDataUseCase
import kotlinx.coroutines.launch


class CatalogViewModel (application: Application) : AndroidViewModel(application) {

    var offsetCount = OFFSET_PAGE
    private val repository = AnimeRepositoryImpl(application)

    private val deleteAnimeUseCase = DeleteAnimeUseCase(repository)
    private val getAnimeListUseCase = GetAnimeListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val listAnime = getAnimeListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase(OFFSET_PAGE)
        }
    }

    fun loadData(){
        viewModelScope.launch {
        loadDataUseCase(offsetCount)
            offsetCount += LIMIT_PAGE
        }
    }


    fun clearDatabase(){
       deleteAnimeUseCase()
    }



    companion object {
        private const val LIMIT_PAGE = 20
        private const val OFFSET_PAGE = 0
            // private const val SORT_BY = "-averageRating"
        private const val SORT_BY = "-userCount"
    }
}