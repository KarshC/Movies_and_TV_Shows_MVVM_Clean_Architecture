package com.example.moviesandtvshows.data.repository.artist.datasourceimpl

import com.example.moviesandtvshows.data.api.TMDBService
import com.example.moviesandtvshows.data.model.artist.ArtistPopularList
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistPopularList> {
        return tmdbService.getPopularPeople(apiKey)
    }
}