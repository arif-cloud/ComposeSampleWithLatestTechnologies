package com.example.soccerapp.data.remote.model.dto


import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("end")
    val end: String?,
    @SerializedName("is_current")
    val isCurrent: Boolean?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("shirt")
    val shirt: String?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("team")
    val teamRole: TeamRole?
)