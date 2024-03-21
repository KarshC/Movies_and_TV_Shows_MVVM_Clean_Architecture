package com.example.moviesandtvshows.domain.usecases

import com.example.moviesandtvshows.data.model.tvshow.TvShow
import com.example.moviesandtvshows.domain.repositories.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}