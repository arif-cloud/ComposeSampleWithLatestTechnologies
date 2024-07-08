package com.example.soccerapp.domain.model


import com.example.soccerapp.data.remote.model.dto.SimpleCountry
import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("country")
    val country: SimpleCountry?,
    @SerializedName("country_id")
    val countryId: String?,
)