package com.stupkalex.kitsucatalog.domain

class GetAnimeListUseCase (private val repository: AnimeRepository) {
    operator fun invoke() = repository.getAnimeList()

}