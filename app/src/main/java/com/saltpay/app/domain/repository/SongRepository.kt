package com.saltpay.app.domain.repository

import com.saltpay.app.data.remote.dto.SongDto

interface SongRepository {
    suspend fun getSongs(): SongDto
}