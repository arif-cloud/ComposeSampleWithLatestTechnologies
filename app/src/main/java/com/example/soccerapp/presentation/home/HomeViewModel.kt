package com.example.soccerapp.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapp.domain.use_case.GetCountries
import com.example.soccerapp.domain.use_case.GetTeamsByCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCountries: GetCountries,
    private val getTeamsByCountry: GetTeamsByCountry
): ViewModel() {

    var selectedCountry = mutableStateOf("England")

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() = viewModelScope.launch {
        try {
            _homeState.value = HomeState(isLoading = true)
            val countries = getCountries().data
            if (countries.isNotEmpty()) {
                val teams = getTeamsByCountry(3).data
                _homeState.value = HomeState(data = HomeData(countryList = countries, teamList = teams))
            }
        } catch (e: Exception) {
            _homeState.value = HomeState(error = e.localizedMessage.orEmpty())
        }
    }

    fun getTeams(countryId: Int) = viewModelScope.launch {
        try {
            val teams = getTeamsByCountry(countryId).data
            val newHomeData = _homeState.value.data?.copy(teamList = teams)
            _homeState.value = HomeState(data = newHomeData)
        } catch (e: Exception) {
            _homeState.value = HomeState(error = e.localizedMessage.orEmpty())
        }
    }
}