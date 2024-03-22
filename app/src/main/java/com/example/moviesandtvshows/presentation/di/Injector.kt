package com.example.moviesandtvshows.presentation.di

import com.example.moviesandtvshows.presentation.di.artist.ArtistSubComponent
import com.example.moviesandtvshows.presentation.di.movie.MovieSubComponent
import com.example.moviesandtvshows.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}