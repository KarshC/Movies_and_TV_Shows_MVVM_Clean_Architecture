package com.example.moviesandtvshows.data.repository.movie.datasourceimpl

import com.example.moviesandtvshows.data.db.MovieDao
import com.example.moviesandtvshows.data.model.movie.Movie
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> {
        return movieDao.getAllMovies()
    }

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}