package com.saltpay.app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saltpay.app.domain.model.Song

data class SongDto(
    @SerializedName("feed")
    val feed: SongFeedDto
)

fun SongDto.toSong() = Song(
    feed = feed.toSongFeed()
)