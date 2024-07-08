package com.example.soccerapp.presentation.root

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object Splash : Screen()

    @Serializable
    data object Home : Screen()

    @Serializable
    data class TeamDetailScreen(
        val teamId : Int
    ) : Screen()

    @Serializable
    data class PlayerDetailScreen(
        val playerId: Int,
        val imageUrl: String,
        val playerName: String
    ) : Screen()

}