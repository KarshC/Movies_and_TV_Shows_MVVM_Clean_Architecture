package com.example.moviesandtvshows.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesandtvshows.domain.usecases.GetMoviesUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        emit(updateMovieUseCase.execute())
    }
}