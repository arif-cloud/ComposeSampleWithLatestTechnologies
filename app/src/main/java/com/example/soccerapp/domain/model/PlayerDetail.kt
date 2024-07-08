package com.example.soccerapp.domain.model


import com.example.soccerapp.data.remote.model.dto.League
import com.example.soccerapp.data.remote.model.dto.Role
import com.example.soccerapp.data.remote.model.dto.SimpleCountry
import com.google.gson.annotations.SerializedName

data class PlayerDetail(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("birthcountry")
    val birthCountry: String?,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("birthplace")
    val birthplace: Any?,
    @SerializedName("common_name")
    val commonName: String?,
    @SerializedName("country")
    val country: SimpleCountry?,
    @SerializedName("firstname")
    val firstname: String?,
    @SerializedName("foot")
    val foot: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("img")
    val img: String?,
    @SerializedName("lastname")
    val lastname: String?,
    @SerializedName("market_value")
    val marketValue: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("national_team_id")
    val nationalTeamId: String?,
    @SerializedName("position")
    val position: Char?,
    @SerializedName("shirtnumber")
    val shirtNumber: String?,
    @SerializedName("team_id")
    val teamId: String?,
    @SerializedName("weight")
    val weight: String?,
    @SerializedName("leagues")
    val leagues: List<League> = emptyList(),
    @SerializedName("roles")
    val roles: List<Role> = emptyList()
)