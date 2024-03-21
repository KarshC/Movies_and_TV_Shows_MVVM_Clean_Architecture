package com.example.moviesandtvshows.data.repository.artist.datasource

import com.example.moviesandtvshows.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDb(): List<Artist>
    suspend fun saveArtistsToDb(artists: List<Artist>)
    suspend fun clearAll()
}