package com.example.soccerapp.data.remote.model.response

import com.example.soccerapp.domain.model.Team

data class TeamsResponse(
    val data: List<Team> = emptyList()
)
