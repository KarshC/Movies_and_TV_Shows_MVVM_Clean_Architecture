package com.example.moviesandtvshows.presentation

import android.app.Application
import com.example.moviesandtvshows.BuildConfig
import com.example.moviesandtvshows.presentation.di.Injector
import com.example.moviesandtvshows.presentation.di.artist.ArtistSubComponent
import com.example.moviesandtvshows.presentation.di.core.AppComponent
import com.example.moviesandtvshows.presentation.di.core.AppModule
import com.example.moviesandtvshows.presentation.di.core.DaggerAppComponent
import com.example.moviesandtvshows.presentation.di.core.NetModule
import com.example.moviesandtvshows.presentation.di.core.RemoteDataModule
import com.example.moviesandtvshows.presentation.di.movie.MovieSubComponent
import com.example.moviesandtvshows.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector{
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.TMDB_BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.TMDB_API_KEY))
            .build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}