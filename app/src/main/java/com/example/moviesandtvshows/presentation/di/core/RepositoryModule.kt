package com.example.moviesandtvshows.presentation.di.core

import com.example.moviesandtvshows.data.repository.artist.ArtistRepositoryImpl
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesandtvshows.data.repository.movie.MovieRepositoryImpl
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieCacheDataSource
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.moviesandtvshows.data.repository.tvshow.TvShowRepositoryImpl
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviesandtvshows.domain.repositories.ArtistRepository
import com.example.moviesandtvshows.domain.repositories.MovieRepository
import com.example.moviesandtvshows.domain.repositories.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistCacheDataSource,
            artistLocalDataSource,
            artistRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowCacheDataSource,
            tvShowRemoteDataSource,
            tvShowLocalDataSource
        )
    }
}