package com.example.soccerapp.data.remote.model.dto


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("current_season_id")
    val currentSeasonId: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("is_amateur")
    val isAmateur: String?,
    @SerializedName("is_cup")
    val isCup: String?,
    @SerializedName("is_friendly")
    val isFriendly: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("seasons")
    val seasons: List<Season?>?
)