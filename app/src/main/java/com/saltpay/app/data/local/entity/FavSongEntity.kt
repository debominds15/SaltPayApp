package com.saltpay.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saltpay.app.data.remote.dto.SongDto
import com.saltpay.app.data.remote.dto.toSongFeed
import com.saltpay.app.domain.model.FavSong
import com.saltpay.app.domain.model.Song

@Entity(tableName = "Favorite")
data class FavSongEntity(
    @PrimaryKey
    var id: String,
    var title: String = "",
    var imageUrl: String? = null,
    var price: String? = null
)

fun FavSongEntity.toFavSong() = FavSong(
    title = title,
    imageUrl = imageUrl ?: "`",
    price = price ?: ""
)