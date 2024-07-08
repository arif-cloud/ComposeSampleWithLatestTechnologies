package com.example.soccerapp.domain.use_case

import com.example.soccerapp.data.remote.model.response.TeamDetailResponse
import com.example.soccerapp.data.remote.model.response.TeamsResponse
import com.example.soccerapp.domain.repository.SoccerRepository
import javax.inject.Inject

class GetTeamByTeamId @Inject constructor(
    private val repository: SoccerRepository
) {
    suspend operator fun invoke(teamId: Int): TeamDetailResponse {
        return repository.getTeamByTeamId(teamId)
    }
}