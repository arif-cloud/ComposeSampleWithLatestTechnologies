package com.example.soccerapp.data.remote.model.response

import com.example.soccerapp.data.remote.model.dto.Meta
import com.example.soccerapp.domain.model.TeamDetail

data class TeamDetailResponse(
    val data: TeamDetail? = null,
    val meta: Meta? = null
)
