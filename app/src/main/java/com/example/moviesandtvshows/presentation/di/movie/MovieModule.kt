package com.example.moviesandtvshows.presentation.di.movie

import com.example.moviesandtvshows.domain.usecases.GetMoviesUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateMovieUseCase
import com.example.moviesandtvshows.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}