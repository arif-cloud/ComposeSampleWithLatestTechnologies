package com.example.soccerapp.data.remote.model.response

import com.example.soccerapp.domain.model.Player

data class PlayerResponse(
    val player: Player,
    val number: Int? = null,
    val captain: String? = null,
    val position: Char? = null,
    val order: String? = null
)
