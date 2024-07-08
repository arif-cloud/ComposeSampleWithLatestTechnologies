package com.example.soccerapp.presentation.team_detail.component

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.soccerapp.data.remote.model.response.PlayerResponse

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.SquadList(
    modifier: Modifier = Modifier,
    squadList: List<PlayerResponse>,
    onClickPlayerItem: (Int, String, String) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(squadList) { playerResponse ->
            PlayerCardItem(
                modifier = Modifier.fillMaxWidth(),
                playerResponse = playerResponse,
                onClick = {
                    onClickPlayerItem(
                        playerResponse.player.id.toInt(),
                        playerResponse.player.img ?: "",
                        playerResponse.player.commonName?.substringBefore(",").orEmpty()
                    )
                },
                animatedVisibilityScope = animatedVisibilityScope
            )
        }
    }
}