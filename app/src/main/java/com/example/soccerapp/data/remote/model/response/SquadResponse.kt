package com.example.soccerapp.data.remote.model.response

import com.example.soccerapp.data.remote.model.dto.Meta
import com.example.soccerapp.data.remote.model.dto.SquadData

data class SquadResponse(
    val data: SquadData? = null,
    val meta: Meta? = null
)
