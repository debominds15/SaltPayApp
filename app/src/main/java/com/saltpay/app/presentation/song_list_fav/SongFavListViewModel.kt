package com.saltpay.app.presentation.song_list_fav

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saltpay.app.common.Resource
import com.saltpay.app.domain.use_case.get_fav_songs.GetFavSongsUseCase
import com.saltpay.app.domain.use_case.get_songs.GetSongsUseCase
import com.saltpay.app.presentation.song_list.SongListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Collections.emptyList
import javax.inject.Inject

@HiltViewModel
class SongFavListViewModel @Inject constructor(
    private val getFavSongsUseCase: GetFavSongsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SongFavListState())
    val state: State<SongFavListState> = _state

    init {
        getFavSongs()
    }

    private fun getFavSongs() {
        getFavSongsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                   /* result.data?.forEach {
                        it.distance = CommonUtils.findDistance(
                            it.coordinate.latitude,
                            it.coordinate.longitude
                        )
                    }*/
                    _state.value = SongFavListState(songs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = SongFavListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = SongFavListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}