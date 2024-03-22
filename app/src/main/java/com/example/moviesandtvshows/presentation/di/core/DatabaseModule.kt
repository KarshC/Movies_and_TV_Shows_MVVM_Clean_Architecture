package com.example.moviesandtvshows.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.moviesandtvshows.data.db.ArtistDao
import com.example.moviesandtvshows.data.db.MovieDao
import com.example.moviesandtvshows.data.db.TMDBDatabase
import com.example.moviesandtvshows.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, name = "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.getMovieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.getTvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.getArtistDao()
    }
}