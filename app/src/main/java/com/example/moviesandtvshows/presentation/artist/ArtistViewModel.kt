package com.example.moviesandtvshows.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesandtvshows.domain.usecases.GetArtistsUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val list = getArtistsUseCase.execute()
        emit(list)
    }

    fun updateArtists() = liveData {
        emit(updateArtistsUseCase.execute())
    }
}