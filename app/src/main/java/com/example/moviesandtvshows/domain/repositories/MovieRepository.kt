package com.example.moviesandtvshows.domain.repositories

import com.example.moviesandtvshows.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}