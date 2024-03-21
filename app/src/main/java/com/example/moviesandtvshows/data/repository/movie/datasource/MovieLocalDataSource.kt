package com.example.moviesandtvshows.data.repository.movie.datasource

import com.example.moviesandtvshows.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDb(): List<Movie>
    suspend fun saveMoviesToDb(movies: List<Movie>)
    suspend fun clearAll()


}