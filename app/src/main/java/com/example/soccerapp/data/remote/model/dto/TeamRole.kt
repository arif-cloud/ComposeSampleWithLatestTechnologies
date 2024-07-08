package com.example.soccerapp.data.remote.model.dto


import com.google.gson.annotations.SerializedName

data class TeamRole(
    @SerializedName("id")
    val id: String?,
    @SerializedName("is_national")
    val isNational: Int?,
    @SerializedName("name")
    val name: String?
)