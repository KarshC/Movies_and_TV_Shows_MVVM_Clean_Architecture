package com.example.moviesandtvshows.data.repository.tvshow.datasourceimpl

import com.example.moviesandtvshows.data.db.TvShowDao
import com.example.moviesandtvshows.data.model.tvshow.TvShow
import com.example.moviesandtvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDb(shows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTvShows(shows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteAllTvShows()
        }
    }
}