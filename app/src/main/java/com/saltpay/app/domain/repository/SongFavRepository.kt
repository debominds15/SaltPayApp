package com.saltpay.app.domain.repository

import com.saltpay.app.data.local.entity.FavSongEntity


interface SongFavRepository {
    suspend fun getFavoriteSongs(): List<FavSongEntity>
    suspend fun saveFavoriteSong(favSong: FavSongEntity): Long
    //suspend fun updateFavoriteSong(id: String, flag: Boolean): Long
}