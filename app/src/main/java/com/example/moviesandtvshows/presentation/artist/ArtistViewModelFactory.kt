package com.example.moviesandtvshows.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesandtvshows.domain.usecases.GetArtistsUseCase
import com.example.moviesandtvshows.domain.usecases.GetTvShowUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateArtistsUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateTvShowUseCase

class ArtistViewModelFactory(private val getArtistsUseCase: GetArtistsUseCase,
                             private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}