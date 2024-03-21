package com.example.moviesandtvshows.data.repository.tvshow

import android.util.Log
import com.example.moviesandtvshows.data.model.tvshow.TvShow
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviesandtvshows.domain.repositories.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getDataFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val tvList = getDataFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDb(tvList)
        tvShowCacheDataSource.saveTvShowsInCache(tvList)
        return tvList
    }

    suspend fun getDataFromCache(): List<TvShow> {
        lateinit var tvList: List<TvShow>
        try {
            tvList = tvShowCacheDataSource.getTvShowsFromCache()
            if (tvList.isEmpty()) {
                tvList = getDataFromDB()
                tvShowCacheDataSource.saveTvShowsInCache(tvList)
            }

        } catch (e: Exception) {
            Log.e("Error Tag", "Error in tv show call")
        }
        return tvList
    }

    suspend fun getDataFromDB(): List<TvShow> {
        lateinit var tvList: List<TvShow>
        try {
            tvList = tvShowLocalDataSource.getTvShowsFromDb()
            if (tvList.isEmpty()) {
                tvList = getDataFromApi()
                tvShowLocalDataSource.saveTvShowsToDb(tvList)
            }
        } catch (e: Exception) {
            Log.e("Error Tag", "Error in tv show call")
        }
        return tvList
    }

    suspend fun getDataFromApi(): List<TvShow> {
        lateinit var tvList: List<TvShow>
        try {
            val responseBody = tvShowRemoteDataSource.getTvShowsFromApi().body()
            if (responseBody != null) {
                tvList = responseBody.tvShowList
            }

        } catch (e: Exception) {
            Log.e("Error Tag", "Error in tv show call")
        }
        return tvList
    }
}