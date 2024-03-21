package com.example.moviesandtvshows.domain.usecases

import com.example.moviesandtvshows.data.model.movie.Movie
import com.example.moviesandtvshows.domain.repositories.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}