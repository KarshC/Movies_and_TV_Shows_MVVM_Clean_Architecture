package com.example.moviesandtvshows.data.repository.movie.datasourceimpl

import com.example.moviesandtvshows.data.model.movie.Movie
import com.example.moviesandtvshows.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesInCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}