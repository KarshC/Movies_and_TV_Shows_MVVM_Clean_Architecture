package com.example.moviesandtvshows.presentation.di.core

import com.example.moviesandtvshows.data.api.TMDBService
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesandtvshows.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.moviesandtvshows.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviesandtvshows.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}