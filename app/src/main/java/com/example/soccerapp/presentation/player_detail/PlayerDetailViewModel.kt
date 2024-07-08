package com.example.soccerapp.presentation.player_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapp.domain.use_case.GetPlayerById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val getPlayerById: GetPlayerById
): ViewModel() {

    private val _playerDetailState = MutableStateFlow(PlayerDetailState())
    val playerDetailState: StateFlow<PlayerDetailState> = _playerDetailState.asStateFlow()

    fun fetchData(playerId: Int) = viewModelScope.launch {
        try {
            _playerDetailState.value = PlayerDetailState(isLoading = true)
            val playerDetail = getPlayerById(playerId).data
            _playerDetailState.value = PlayerDetailState(data = playerDetail)
        } catch (e: Exception) {
            _playerDetailState.value = PlayerDetailState(error = e.localizedMessage.orEmpty())
        }
    }

}