package com.saltpay.app.domain.use_case.get_fav_songs

import com.saltpay.app.common.Resource
import com.saltpay.app.data.local.entity.toFavSong
import com.saltpay.app.domain.model.FavSong
import com.saltpay.app.domain.repository.SongFavRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFavSongsUseCase @Inject constructor(
    private val repository: SongFavRepository
) {
    operator fun invoke(): Flow<Resource<List<FavSong>>> = flow {
        try {
            emit(Resource.Loading<List<FavSong>>())
            val songs = repository.getFavoriteSongs().map { it.toFavSong() }
            emit(Resource.Success(songs))
        } catch(e: HttpException) {
            emit(Resource.Error<List<FavSong>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<FavSong>>("Couldn't reach server. Check your internet connection and try again."))
        }
    }
}