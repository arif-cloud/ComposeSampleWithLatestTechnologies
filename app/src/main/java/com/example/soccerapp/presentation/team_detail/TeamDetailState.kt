package com.example.soccerapp.presentation.team_detail

import com.example.soccerapp.data.remote.model.response.PlayerResponse
import com.example.soccerapp.domain.model.TeamDetail

data class TeamDetailState(
    val isLoading: Boolean = false,
    val data: TeamDetailData? = null,
    val error: String = ""
)

data class TeamDetailData(
    val teamDetail: TeamDetail? = null,
    val squadList: List<PlayerResponse> = emptyList()
)
