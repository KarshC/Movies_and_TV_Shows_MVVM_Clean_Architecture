package com.example.moviesandtvshows.presentation.di.core

import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesandtvshows.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieCacheDataSource
import com.example.moviesandtvshows.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviesandtvshows.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}