package com.stupkalex.kitsucatalog.domain

class DeleteAnimeUseCase(private val repository: AnimeRepository) {
    operator fun invoke(){
        repository.deleteAnime()
    }
}