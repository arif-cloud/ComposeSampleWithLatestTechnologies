package com.example.soccerapp.domain.repository

import com.example.soccerapp.data.remote.model.response.CountriesResponse
import com.example.soccerapp.data.remote.model.response.PlayerDetailResponse
import com.example.soccerapp.data.remote.model.response.SquadResponse
import com.example.soccerapp.data.remote.model.response.TeamDetailResponse
import com.example.soccerapp.data.remote.model.response.TeamsResponse

interface SoccerRepository {

    suspend fun getCountries(): CountriesResponse

    suspend fun getTeamsByCountry(countryId: Int): TeamsResponse

    suspend fun getTeamByTeamId(teamId: Int): TeamDetailResponse

    suspend fun getSquadByTeamId(teamId: Int): SquadResponse

    suspend fun getPlayerById(playerId: Int): PlayerDetailResponse
}