package com.example.moviesandtvshows.data.repository.movie

import android.util.Log
import com.example.moviesandtvshows.data.model.movie.Movie
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieCacheDataSource
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.moviesandtvshows.domain.repositories.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val list = getMoviesFromRemote()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDb(list)
        movieCacheDataSource.saveMoviesInCache(list)
        return list
    }

    suspend fun getMoviesFromRemote(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val responseBody = movieRemoteDataSource.getMovies().body()

            responseBody?.let {
                movieList = it.movieList
            }

        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val list = movieLocalDataSource.getMoviesFromDb()
            if (list.isNotEmpty()) {
                movieList = list
            } else {
                movieList = getMoviesFromRemote()
                movieLocalDataSource.saveMoviesToDb(movieList)
            }
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val list = movieCacheDataSource.getMoviesFromCache()
            if (list.isNotEmpty()) {
                movieList = list
            } else {
                movieList = getMoviesFromDB()
                movieCacheDataSource.saveMoviesInCache(movieList)
            }
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

        return movieList
    }
}