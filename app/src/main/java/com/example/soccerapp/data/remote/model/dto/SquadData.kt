package com.example.soccerapp.data.remote.model.dto

import com.example.soccerapp.data.remote.model.response.PlayerResponse

data class SquadData(
    val formation: String?,
    val squad: List<PlayerResponse>
)
