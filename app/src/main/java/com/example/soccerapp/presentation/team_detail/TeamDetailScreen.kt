package com.example.soccerapp.presentation.team_detail

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.soccerapp.presentation.root.ErrorText
import com.example.soccerapp.presentation.root.LoadingAnimation
import com.example.soccerapp.presentation.root.Screen
import com.example.soccerapp.presentation.team_detail.component.SquadList
import com.example.soccerapp.presentation.team_detail.component.TeamInfoSection
import com.example.soccerapp.presentation.team_detail.component.TeamLogo
import com.example.soccerapp.presentation.ui.theme.Typography

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.TeamDetailScreen(
    teamId: Int,
    navController: NavController,
    animatedVisibilityScope: AnimatedVisibilityScope,
    viewModel: TeamDetailViewModel = hiltViewModel(),
) {
    val state by viewModel.teamDetailState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        if (state.data == null)
            viewModel.fetchData(teamId)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        state.data?.let { teamDetailData ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            ) {
                TeamInfoSection(
                    modifier = Modifier.fillMaxWidth(),
                    teamDetail = teamDetailData.teamDetail
                )
                Spacer(modifier = Modifier.height(10.dp))
                SquadList(
                    modifier = Modifier.fillMaxWidth(),
                    squadList = teamDetailData.squadList,
                    onClickPlayerItem = { playerId, imageUrl, playerName -> navController.navigate(Screen.PlayerDetailScreen(playerId, imageUrl, playerName)) },
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
        }
        if (state.isLoading)
            LoadingAnimation(modifier = Modifier.align(Alignment.Center))
        if (state.error.isNotEmpty())
            ErrorText(
                errorMessage = state.error,
                modifier = Modifier.align(Alignment.Center)
            )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevTeamDetailScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                TeamLogo(
                    logoImage = ""
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = "Arsenal")
                    Text(text = "Premier League")
                    Text(text = "England")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0XFFEADC84)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        AsyncImage(
                            model = "https://cdn.soccersapi.com/images/soccer/players/50/17322.png",
                            contentDescription = "player_image",
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "$index  Ferdito",
                            modifier = Modifier.weight(1f),
                            style = Typography.titleMedium,
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "drop_down",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
        }
    }
}