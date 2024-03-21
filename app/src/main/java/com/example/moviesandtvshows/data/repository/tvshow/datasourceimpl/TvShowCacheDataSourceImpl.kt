package com.example.moviesandtvshows.data.repository.tvshow.datasourceimpl

import com.example.moviesandtvshows.data.model.tvshow.TvShow
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsInCache(shows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(shows)
    }
}