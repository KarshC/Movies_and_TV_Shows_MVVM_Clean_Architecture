package com.example.moviesandtvshows.data.repository.tvshow.datasource

import com.example.moviesandtvshows.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDb(): List<TvShow>
    suspend fun saveTvShowsToDb(shows: List<TvShow>)
    suspend fun clearAll()
}