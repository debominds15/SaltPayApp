package com.saltpay.app.data.repository

import com.google.gson.Gson
import com.saltpay.app.data.remote.dto.SongApi
import com.saltpay.app.data.remote.dto.SongDto
import com.saltpay.app.domain.repository.SongRepository
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val api: SongApi
) : SongRepository {
    override suspend fun getSongs(): SongDto {
        //val response =
        //val gson = Gson()
        return api.getAllSongs()
    }

}