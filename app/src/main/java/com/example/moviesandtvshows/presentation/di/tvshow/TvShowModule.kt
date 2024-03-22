package com.example.moviesandtvshows.presentation.di.tvshow

import com.example.moviesandtvshows.domain.usecases.GetTvShowUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateTvShowUseCase
import com.example.moviesandtvshows.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }
}