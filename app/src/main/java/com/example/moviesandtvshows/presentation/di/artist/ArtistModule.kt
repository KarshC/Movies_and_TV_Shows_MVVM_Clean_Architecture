package com.example.moviesandtvshows.presentation.di.artist

import com.example.moviesandtvshows.domain.usecases.GetArtistsUseCase
import com.example.moviesandtvshows.domain.usecases.UpdateArtistsUseCase
import com.example.moviesandtvshows.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}