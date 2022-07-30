package com.saltpay.app.domain.use_case.get_songs

import com.saltpay.app.common.Resource
import com.saltpay.app.data.remote.dto.SongDto
import com.saltpay.app.data.remote.dto.toSong
import com.saltpay.app.domain.model.Entry
import com.saltpay.app.domain.model.Song
import com.saltpay.app.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSongsUseCase @Inject constructor(
    private val repository: SongRepository
) {
    operator fun invoke(): Flow<Resource<List<Entry>>> = flow {
        try {
            emit(Resource.Loading<List<Entry>>())
            val songs = repository.getSongs().toSong().feed.entry
            emit(Resource.Success(songs))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Entry>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Entry>>("Couldn't reach server. Check your internet connection and try again."))
        }
    }
}