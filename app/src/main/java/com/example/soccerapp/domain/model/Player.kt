package com.example.soccerapp.domain.model

import com.example.soccerapp.data.remote.model.dto.SimpleCountry
import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("common_name")
    val commonName: String?,
    @SerializedName("country")
    val country: SimpleCountry?,
    @SerializedName("firstname")
    val firstname: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String?,
    @SerializedName("lastname")
    val lastname: String?,
    @SerializedName("name")
    val name: Any?,
    @SerializedName("weight")
    val weight: String?
)