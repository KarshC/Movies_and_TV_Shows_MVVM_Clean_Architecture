package com.example.moviesandtvshows.data.model.artist


import com.google.gson.annotations.SerializedName

data class ArtistPopularList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("people")
    val artistList: List<Artist>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)