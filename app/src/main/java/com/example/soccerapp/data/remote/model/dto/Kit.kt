package com.example.soccerapp.data.remote.model.dto


import com.google.gson.annotations.SerializedName

data class Kit(
    @SerializedName("away2_main_color")
    val away2MainColor: String?,
    @SerializedName("away2_number_color")
    val away2NumberColor: String?,
    @SerializedName("away2_second_color")
    val away2SecondColor: String?,
    @SerializedName("away_main_color")
    val awayMainColor: String?,
    @SerializedName("away_number_color")
    val awayNumberColor: String?,
    @SerializedName("away_second_color")
    val awaySecondColor: String?,
    @SerializedName("goalkeeper_main_color")
    val goalkeeperMainColor: String?,
    @SerializedName("goalkeeper_number_color")
    val goalkeeperNumberColor: String?,
    @SerializedName("goalkeeper_second_color")
    val goalkeeperSecondColor: String?,
    @SerializedName("home_main_color")
    val homeMainColor: String?,
    @SerializedName("home_number_color")
    val homeNumberColor: String?,
    @SerializedName("home_second_color")
    val homeSecondColor: String?
)