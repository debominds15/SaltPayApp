package com.saltpay.app.presentation

sealed class ScreenType(val route: String) {
    object SongListScreen : ScreenType("song_list_screen")
    object SongDetailScreen : ScreenType("song_detail_screen")
}