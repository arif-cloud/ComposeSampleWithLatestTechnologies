package com.example.soccerapp.domain.use_case

import com.example.soccerapp.data.remote.model.response.PlayerDetailResponse
import com.example.soccerapp.domain.repository.SoccerRepository
import javax.inject.Inject

class GetPlayerById @Inject constructor(
    private val repository: SoccerRepository
) {
    suspend operator fun invoke(playerId: Int): PlayerDetailResponse {
        return repository.getPlayerById(playerId)
    }
}