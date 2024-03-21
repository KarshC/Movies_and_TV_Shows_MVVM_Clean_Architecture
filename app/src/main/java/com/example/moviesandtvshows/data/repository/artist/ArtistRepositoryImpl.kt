package com.example.moviesandtvshows.data.repository.artist

import android.util.Log
import com.example.moviesandtvshows.data.model.artist.Artist
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesandtvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesandtvshows.domain.repositories.ArtistRepository

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val list = getArtistsFromRemote()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDb(list)
        artistCacheDataSource.saveArtistsInCache(list)
        return list
    }

    suspend fun getArtistsFromRemote(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val responseBody = artistRemoteDataSource.getArtists().body()

            responseBody?.let {
                artistList = it.artistList
            }

        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val list = artistLocalDataSource.getArtistsFromDb()
            if (list.isNotEmpty()) {
                artistList = list
            } else {
                artistList = getArtistsFromRemote()
                artistLocalDataSource.saveArtistsToDb(artistList)
            }
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val list = artistCacheDataSource.getArtistsFromCache()
            if (list.isNotEmpty()) {
                artistList = list
            } else {
                artistList = getArtistsFromDB()
                artistCacheDataSource.saveArtistsInCache(artistList)
            }
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
        }

        return artistList
    }
}