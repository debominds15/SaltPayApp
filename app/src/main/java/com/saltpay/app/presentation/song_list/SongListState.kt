package com.saltpay.app.presentation.song_list

import com.saltpay.app.domain.model.Entry
import java.util.Collections.emptyList

data class SongListState(
    val isLoading: Boolean = false,
    val songs: List<Entry> = emptyList(),
    val error: String = ""
)
