package com.stupkalex.kitsucatalog.domain

class LoadDataUseCase(private val repository: AnimeRepository) {
    suspend operator fun invoke(offset: Int){
        repository.loadData(offset)
    }
}