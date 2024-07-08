package com.example.soccerapp.domain.model

import com.example.soccerapp.data.remote.model.dto.Kit
import com.example.soccerapp.data.remote.model.dto.League
import com.example.soccerapp.data.remote.model.dto.SimpleCountry
import com.google.gson.annotations.SerializedName

data class TeamDetail(
    @SerializedName("coach_id")
    val coachId: Int?,
    @SerializedName("common_name")
    val commonName: String?,
    @SerializedName("country")
    val country: SimpleCountry?,
    @SerializedName("current_seasons")
    val currentSeasons: List<Int>?,
    @SerializedName("founded")
    val founded: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("img")
    val img: String?,
    @SerializedName("is_national")
    val isNational: Int?,
    @SerializedName("kit")
    val kit: Kit?,
    @SerializedName("leagues")
    val leagues: List<League>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("short_code")
    val shortCode: String?,
    @SerializedName("twitter")
    val twitter: String?,
    @SerializedName("venue_id")
    val venueId: Int?
)