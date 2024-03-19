package com.example.moviesandtvshows.data


import com.google.gson.annotations.SerializedName

data class PeoplePopularList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("people")
    val peopleList: List<People>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)