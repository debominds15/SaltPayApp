package com.saltpay.app.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SongApi {
    @GET("limit=100/json")
    suspend fun getAllSongs(): SongDto
}