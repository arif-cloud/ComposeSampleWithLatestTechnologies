package com.example.soccerapp.data.remote.model.dto


import com.google.gson.annotations.SerializedName

data class SimpleCountry(
    @SerializedName("cc")
    val cc: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)