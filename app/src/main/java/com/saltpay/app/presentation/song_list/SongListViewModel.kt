package com.saltpay.app.presentation.song_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saltpay.app.common.Resource
import com.saltpay.app.domain.use_case.get_songs.GetSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Collections.emptyList
import javax.inject.Inject

@HiltViewModel
class SongListViewModel @Inject constructor(
    private val getSongsUseCase: GetSongsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SongListState())
    val state: State<SongListState> = _state

    init {
        getSongs()
    }

    private fun getSongs() {
        getSongsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                   /* result.data?.forEach {
                        it.distance = CommonUtils.findDistance(
                            it.coordinate.latitude,
                            it.coordinate.longitude
                        )
                    }*/
                    _state.value = SongListState(songs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = SongListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = SongListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}