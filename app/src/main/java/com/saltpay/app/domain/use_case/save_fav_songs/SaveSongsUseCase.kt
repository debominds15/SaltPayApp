package com.saltpay.app.domain.use_case.save_fav_songs

import com.saltpay.app.common.Resource
import com.saltpay.app.data.remote.dto.SongDto
import com.saltpay.app.data.remote.dto.toSong
import com.saltpay.app.domain.model.Entry
import com.saltpay.app.domain.model.FavSong
import com.saltpay.app.domain.model.Song
import com.saltpay.app.domain.model.toEntity
import com.saltpay.app.domain.repository.SongFavRepository
import com.saltpay.app.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SaveSongsUseCase @Inject constructor(
    private val repository: SongFavRepository
) {
    fun saveFavoriteSong(song: FavSong): Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading<Boolean>())
            val songs = repository.saveFavoriteSong(song.toEntity())
            emit(Resource.Success(true))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't saved as Favorite. Please try again."))
        }
    }
}