package com.saltpay.app.data.repository

import com.google.gson.Gson
import com.saltpay.app.data.local.AppDatabase
import com.saltpay.app.data.local.entity.FavSongEntity
import com.saltpay.app.domain.repository.SongFavRepository
import javax.inject.Inject

class SongFavRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
) : SongFavRepository {
    override suspend fun getFavoriteSongs(): List<FavSongEntity> {
        return database.favoritesDao.loadAll()
    }

    override suspend fun saveFavoriteSong(favSong: FavSongEntity): Long {
        return database.favoritesDao.insert(favSong)
    }

    /*override suspend fun updateFavoriteSong(id: String, flag: Boolean): Long {
        return database.favoritesDao.insert()
    }*/
}