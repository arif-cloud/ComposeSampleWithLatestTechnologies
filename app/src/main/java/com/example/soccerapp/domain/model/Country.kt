package com.example.soccerapp.domain.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("id")
    val id: String,
    @SerializedName("code")
    val code: String?,
    @SerializedName("continent")
    val continent: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("sub_region")
    val subRegion: Any?
)