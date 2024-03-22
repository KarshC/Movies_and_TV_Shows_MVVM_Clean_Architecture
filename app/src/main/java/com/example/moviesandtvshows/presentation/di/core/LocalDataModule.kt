package com.example.moviesandtvshows.presentation.di.core

import com.example.moviesandtvshows.data.db.ArtistDao
import com.example.moviesandtvshows.data.db.MovieDao
import com.example.moviesandtvshows.data.db.TvShowDao
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesandtvshows.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviesandtvshows.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviesandtvshows.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}