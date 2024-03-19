package com.example.moviesandtvshows.data.model


import com.google.gson.annotations.SerializedName

data class MoviePopularList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("movies")
    val movieList: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)