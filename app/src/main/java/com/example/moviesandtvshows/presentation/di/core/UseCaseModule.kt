package com.example.moviesandtvshows.presentation.di.core

import com.example.moviesandtvshows.domain.repositories.ArtistRepository
import com.example.moviesandtvshows.domain.repositories.MovieRepository
import com.example.moviesandtvshows.domain.repositories.TvShowRepository
import com.example.moviesandtvshows.domain.usecases.GetArtistsUseCase
import com.example.moviesandtvshows.domain.usecases.GetMoviesUseCase
import com.example.moviesandtvshows.domain.usecases.GetTvShowUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateArtistsUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateMovieUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }
}