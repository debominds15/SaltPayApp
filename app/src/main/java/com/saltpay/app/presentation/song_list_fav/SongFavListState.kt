package com.saltpay.app.presentation.song_list_fav

import com.saltpay.app.domain.model.FavSong
import java.util.Collections.emptyList

data class SongFavListState(
    val isLoading: Boolean = false,
    val songs: List<FavSong> = emptyList(),
    val error: String = ""
)
