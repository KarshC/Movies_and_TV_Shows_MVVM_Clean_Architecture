package com.example.moviesandtvshows.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesandtvshows.data.model.artist.Artist
import com.example.moviesandtvshows.data.model.movie.Movie
import com.example.moviesandtvshows.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
    abstract fun getTvShowDao(): TvShowDao
    abstract fun getArtistDao(): ArtistDao

}