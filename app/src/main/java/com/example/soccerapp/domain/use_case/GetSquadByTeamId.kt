package com.example.soccerapp.domain.use_case

import com.example.soccerapp.data.remote.model.response.SquadResponse
import com.example.soccerapp.data.remote.model.response.TeamsResponse
import com.example.soccerapp.domain.repository.SoccerRepository
import javax.inject.Inject

class GetSquadByTeamId @Inject constructor(
    private val repository: SoccerRepository
) {
    suspend operator fun invoke(teamId: Int): SquadResponse {
        return repository.getSquadByTeamId(teamId)
    }
}