package com.example.moviesandtvshows.domain.repositories

import com.example.moviesandtvshows.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}