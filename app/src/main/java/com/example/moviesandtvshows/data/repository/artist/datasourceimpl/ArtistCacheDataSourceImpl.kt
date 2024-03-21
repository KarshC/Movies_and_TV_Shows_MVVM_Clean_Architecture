package com.example.moviesandtvshows.data.repository.artist.datasourceimpl

import com.example.moviesandtvshows.data.model.artist.Artist
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistsList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistsInCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }
}