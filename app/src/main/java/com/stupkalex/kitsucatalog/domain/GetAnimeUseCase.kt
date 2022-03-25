package com.stupkalex.kitsucatalog.domain

class GetAnimeUseCase(private val repository: AnimeRepository) {
    operator fun invoke(animeId: Int) = repository.getAnime(animeId)

}