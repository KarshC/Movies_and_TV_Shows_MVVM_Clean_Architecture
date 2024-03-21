package com.example.moviesandtvshows.domain.usecases

import com.example.moviesandtvshows.data.model.artist.Artist
import com.example.moviesandtvshows.domain.repositories.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}