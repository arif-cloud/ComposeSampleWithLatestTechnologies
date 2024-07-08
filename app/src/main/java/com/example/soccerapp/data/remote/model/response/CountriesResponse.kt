package com.example.soccerapp.data.remote.model.response

import com.example.soccerapp.domain.model.Country

data class CountriesResponse(
    val data: List<Country> = emptyList()
)
