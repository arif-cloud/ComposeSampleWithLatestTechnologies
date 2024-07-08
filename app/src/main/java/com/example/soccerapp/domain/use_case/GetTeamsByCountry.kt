package com.example.soccerapp.domain.use_case

import com.example.soccerapp.data.remote.model.response.TeamsResponse
import com.example.soccerapp.domain.repository.SoccerRepository
import javax.inject.Inject

class GetTeamsByCountry @Inject constructor(
    private val repository: SoccerRepository
) {
    suspend operator fun invoke(countryId: Int): TeamsResponse {
        return repository.getTeamsByCountry(countryId)
    }
}