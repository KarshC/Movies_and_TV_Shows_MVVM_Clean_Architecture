package com.example.moviesandtvshows.domain.repositories

import com.example.moviesandtvshows.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}