package com.example.moviesandtvshows.data.repository.tvshow.datasourceimpl

import com.example.moviesandtvshows.data.api.TMDBService
import com.example.moviesandtvshows.data.model.tvshow.TvPopularList
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TvShowRemoteDataSource {
    override suspend fun getTvShowsFromApi(): Response<TvPopularList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}