package com.saltpay.app.domain.model

import com.saltpay.app.data.local.entity.FavSongEntity
import com.saltpay.app.data.remote.dto.EntryDto
import com.saltpay.app.data.remote.dto.toImage
import com.saltpay.app.data.remote.dto.toLabel

data class FavSong(
    val title: String,
    val imageUrl: String,
    val price: String
)

fun FavSong.toEntity(): FavSongEntity {
    return FavSongEntity(
        id = title,
        title = title,
        imageUrl = imageUrl,
        price = price
    )
}