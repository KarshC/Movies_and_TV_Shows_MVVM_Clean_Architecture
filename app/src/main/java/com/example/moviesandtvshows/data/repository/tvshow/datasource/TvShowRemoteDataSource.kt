package com.example.moviesandtvshows.data.repository.tvshow.datasource

import com.example.moviesandtvshows.data.model.tvshow.TvPopularList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShowsFromApi(): Response<TvPopularList>
}