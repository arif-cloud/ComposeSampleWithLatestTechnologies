package com.example.soccerapp.data.remote.model.dto


import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("id")
    val id: String?,
    @SerializedName("is_current")
    val isCurrent: String?,
    @SerializedName("name")
    val name: String?
)