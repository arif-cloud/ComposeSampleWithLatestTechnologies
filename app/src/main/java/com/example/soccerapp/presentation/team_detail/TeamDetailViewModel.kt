package com.example.soccerapp.presentation.team_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerapp.domain.use_case.GetSquadByTeamId
import com.example.soccerapp.domain.use_case.GetTeamByTeamId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val getTeamByTeamId: GetTeamByTeamId,
    private val getSquadByTeamId: GetSquadByTeamId
): ViewModel() {

    private val _teamDetailState = MutableStateFlow(TeamDetailState())
    val teamDetailState: StateFlow<TeamDetailState> = _teamDetailState.asStateFlow()

    fun fetchData(teamId: Int) = viewModelScope.launch {
        try {
            _teamDetailState.value = TeamDetailState(isLoading = true)
            val teamDetail = getTeamByTeamId(teamId).data
            getSquadByTeamId(teamId).data?.squad?.let {squadList ->
                _teamDetailState.value = TeamDetailState(data = TeamDetailData(teamDetail = teamDetail, squadList = squadList))
            }
        } catch (e: Exception) {
            _teamDetailState.value = TeamDetailState(error = e.localizedMessage.orEmpty())
        }
    }


}