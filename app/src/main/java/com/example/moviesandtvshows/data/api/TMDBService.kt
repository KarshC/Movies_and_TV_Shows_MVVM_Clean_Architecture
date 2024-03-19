package com.example.moviesandtvshows.data.api

import com.example.moviesandtvshows.data.model.MoviePopularList
import com.example.moviesandtvshows.data.model.PeoplePopularList
import com.example.moviesandtvshows.data.model.TvPopularList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): Response<MoviePopularList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvPopularList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String): Response<PeoplePopularList>
}