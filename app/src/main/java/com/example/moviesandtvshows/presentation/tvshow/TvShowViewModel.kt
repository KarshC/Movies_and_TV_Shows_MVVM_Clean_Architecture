package com.example.moviesandtvshows.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesandtvshows.domain.usecases.GetTvShowUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val list = getTvShowUseCase.execute()
        emit(list)
    }

    fun updateTvShows() = liveData {
        emit(updateTvShowUseCase.execute())
    }
}