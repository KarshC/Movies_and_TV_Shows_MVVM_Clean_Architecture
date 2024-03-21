package com.example.moviesandtvshows.data.repository.artist.datasource

import com.example.moviesandtvshows.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsInCache(artists: List<Artist>)
}