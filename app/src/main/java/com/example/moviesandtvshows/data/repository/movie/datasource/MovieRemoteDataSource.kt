package com.example.moviesandtvshows.data.repository.movie.datasource

import com.example.moviesandtvshows.data.model.movie.MoviePopularList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MoviePopularList>
}