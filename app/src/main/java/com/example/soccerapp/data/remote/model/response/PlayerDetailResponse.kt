package com.example.soccerapp.data.remote.model.response

import com.example.soccerapp.data.remote.model.dto.Meta
import com.example.soccerapp.domain.model.PlayerDetail

data class PlayerDetailResponse(
    val data: PlayerDetail? = null,
    val meta: Meta? = null
)
