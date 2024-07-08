package com.example.soccerapp.presentation.player_detail

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.soccerapp.R
import com.example.soccerapp.common.getFormattedPlayerPosition
import com.example.soccerapp.presentation.player_detail.component.PlayerAttributes
import com.example.soccerapp.presentation.player_detail.component.PlayerDetailDivider
import com.example.soccerapp.presentation.root.ErrorText
import com.example.soccerapp.presentation.root.LoadingAnimation
import com.example.soccerapp.presentation.ui.theme.Gold
import com.example.soccerapp.presentation.ui.theme.Typography

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.PlayerDetailScreen(
    playerId: Int,
    imageUrl: String,
    playerName: String,
    viewModel: PlayerDetailViewModel = hiltViewModel(),
    navController: NavController,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    val state by viewModel.playerDetailState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchData(playerId)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Gold)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                content = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back_icon"
                    )
                }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "player_image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .sharedBounds(
                            sharedContentState = rememberSharedContentState(key = "image/$imageUrl"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ -> tween(durationMillis = 1000) }
                        ),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = playerName,
                    style = Typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .sharedElement(
                            state = rememberSharedContentState(key = "name/$playerName"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ -> tween(durationMillis = 1000) }
                        )
                )
            }
            PlayerDetailDivider()
            state.data?.let { playerDetail ->
                PlayerAttributes(
                    modifier = Modifier.fillMaxWidth(),
                    attributes = listOf(
                        "Country" to playerDetail.country?.name.orEmpty(),
                        "Position" to playerDetail.position.getFormattedPlayerPosition(),
                        "Foot" to playerDetail.foot.orEmpty(),
                        "Market Value" to playerDetail.marketValue.orEmpty()
                    )
                )
            }
            if (state.isLoading) {
                Spacer(modifier = Modifier.height(20.dp))
                LoadingAnimation(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            if (state.error.isNotEmpty())
                ErrorText(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    errorMessage = state.error
                )
        }
    }
}