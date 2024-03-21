package com.example.moviesandtvshows.data.repository.artist.datasource

import com.example.moviesandtvshows.data.model.artist.ArtistPopularList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistPopularList>
}