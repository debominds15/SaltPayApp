package com.saltpay.app.presentation.song_list.components

import com.saltpay.app.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("hom", R.drawable.ic_baseline_home_24, "Home")
    object Fav : NavigationItem("fav", R.drawable.ic_baseline_favorite_border_24, "Favorite")
}