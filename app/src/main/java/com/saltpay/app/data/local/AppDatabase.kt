package com.saltpay.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saltpay.app.data.local.dao.FavoriteDao
import com.saltpay.app.data.local.entity.FavSongEntity

    @Database(
        entities = [FavSongEntity::class],
        version = 1,
        exportSchema = false
    )
    abstract class AppDatabase : RoomDatabase() {
        abstract val favoritesDao: FavoriteDao

        companion object {
            const val DB_NAME = "FavSongDatabase.db"
        }
    }