package com.saltpay.app.data.local.dao

import androidx.room.*
import com.saltpay.app.data.local.entity.FavSongEntity

/**
 * it provides access to [Favorite Case Studies] underlying database
 * */
@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: FavSongEntity): Long

    @Query("SELECT * FROM Favorite")
    fun loadAll(): List<FavSongEntity>

    @Query("DELETE FROM Favorite")
    fun deleteAll()

    //@Query("SELECT * FROM Favorite where id = :favSongId")
    //suspend fun loadFavoritesBySongId(favSongId: Int): FavSongEntity

   /* @Update
    fun update(entity: FavSongEntity)*/
}