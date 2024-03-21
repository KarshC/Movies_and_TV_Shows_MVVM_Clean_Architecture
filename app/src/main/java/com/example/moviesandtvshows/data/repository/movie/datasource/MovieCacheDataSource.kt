package com.example.moviesandtvshows.data.repository.movie.datasource

import com.example.moviesandtvshows.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesInCache(movies: List<Movie>)
}