package com.example.moviesandtvshows.data


import com.google.gson.annotations.SerializedName

data class TvPopularList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("TVS")
    val tvShowList: List<TvShow>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)