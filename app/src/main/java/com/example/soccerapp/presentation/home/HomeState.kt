package com.example.soccerapp.presentation.home

import com.example.soccerapp.domain.model.Country
import com.example.soccerapp.domain.model.Team

data class HomeState(
    val isLoading: Boolean = false,
    val data: HomeData? = null,
    val error: String = ""
)

data class HomeData(
    val countryList: List<Country> = emptyList(),
    val teamList: List<Team> = emptyList()
)
