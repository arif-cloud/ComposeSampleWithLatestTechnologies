package com.example.soccerapp.data.remote

import com.example.soccerapp.common.Constants
import com.example.soccerapp.data.remote.model.response.CountriesResponse
import com.example.soccerapp.data.remote.model.response.PlayerDetailResponse
import com.example.soccerapp.data.remote.model.response.SquadResponse
import com.example.soccerapp.data.remote.model.response.TeamDetailResponse
import com.example.soccerapp.data.remote.model.response.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SoccerApi {

    @GET("countries")
    suspend fun getCountries(
        @Query("user") username: String = Constants.USERNAME,
        @Query("token") apiKey: String = Constants.API_KEY,
        @Query("t") format: String = "list"
    ): CountriesResponse

    @GET("teams")
    suspend fun getTeamsByCountry(
        @Query("user") username: String = Constants.USERNAME,
        @Query("token") apiKey: String = Constants.API_KEY,
        @Query("t") format: String = "list",
        @Query("country_id") countryId: Int
    ): TeamsResponse

    @GET("teams")
    suspend fun getTeamByTeamId(
        @Query("user") username: String = Constants.USERNAME,
        @Query("token") apiKey: String = Constants.API_KEY,
        @Query("t") format: String = "info",
        @Query("id") teamId: Int
    ): TeamDetailResponse

    @GET("teams")
    suspend fun getSquadByTeamId(
        @Query("user") username: String = Constants.USERNAME,
        @Query("token") apiKey: String = Constants.API_KEY,
        @Query("t") format: String = "squad",
        @Query("id") teamId: Int
    ): SquadResponse

    @GET("players")
    suspend fun getPlayerById(
        @Query("user") username: String = Constants.USERNAME,
        @Query("token") apiKey: String = Constants.API_KEY,
        @Query("t") format: String = "info",
        @Query("id") playerId: Int
    ): PlayerDetailResponse

}