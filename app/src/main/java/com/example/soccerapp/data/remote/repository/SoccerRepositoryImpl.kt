package com.example.soccerapp.data.remote.repository

import com.example.soccerapp.data.remote.SoccerApi
import com.example.soccerapp.data.remote.model.response.CountriesResponse
import com.example.soccerapp.data.remote.model.response.PlayerDetailResponse
import com.example.soccerapp.data.remote.model.response.SquadResponse
import com.example.soccerapp.data.remote.model.response.TeamDetailResponse
import com.example.soccerapp.data.remote.model.response.TeamsResponse
import com.example.soccerapp.domain.repository.SoccerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SoccerRepositoryImpl @Inject constructor(
    private val api: SoccerApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : SoccerRepository {

    override suspend fun getCountries(): CountriesResponse = withContext(ioDispatcher) {
        api.getCountries()
    }

    override suspend fun getTeamsByCountry(countryId: Int): TeamsResponse = withContext(ioDispatcher) {
        api.getTeamsByCountry(countryId = countryId)
    }

    override suspend fun getTeamByTeamId(teamId: Int): TeamDetailResponse = withContext(ioDispatcher) {
        api.getTeamByTeamId(teamId = teamId)
    }

    override suspend fun getSquadByTeamId(teamId: Int): SquadResponse = withContext(ioDispatcher) {
        api.getSquadByTeamId(teamId = teamId)
    }

    override suspend fun getPlayerById(playerId: Int): PlayerDetailResponse = withContext(ioDispatcher) {
        api.getPlayerById(playerId = playerId)
    }

}