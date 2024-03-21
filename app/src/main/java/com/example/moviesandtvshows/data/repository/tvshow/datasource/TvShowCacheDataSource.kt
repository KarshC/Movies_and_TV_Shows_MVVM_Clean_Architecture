package com.example.moviesandtvshows.data.repository.tvshow.datasource

import com.example.moviesandtvshows.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsInCache(shows: List<TvShow>)
}