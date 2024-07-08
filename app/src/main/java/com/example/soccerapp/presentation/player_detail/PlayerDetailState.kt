package com.example.soccerapp.presentation.player_detail

import com.example.soccerapp.domain.model.PlayerDetail

data class PlayerDetailState(
    val isLoading: Boolean = false,
    val data: PlayerDetail? = null,
    val error: String = ""
)
