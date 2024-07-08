package com.example.soccerapp.data.remote.model.dto


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("plan")
    val plan: String?,
    @SerializedName("requests_left")
    val requestsLeft: Int?,
    @SerializedName("user")
    val user: String?
)