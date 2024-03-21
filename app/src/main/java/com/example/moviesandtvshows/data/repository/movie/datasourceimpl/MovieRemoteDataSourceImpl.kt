package com.example.moviesandtvshows.data.repository.movie.datasourceimpl

import com.example.moviesandtvshows.data.api.TMDBService
import com.example.moviesandtvshows.data.model.movie.MoviePopularList
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MoviePopularList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}