package com.example.soccerapp.presentation.team_detail.component

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.soccerapp.common.getFormattedPlayerPosition
import com.example.soccerapp.data.remote.model.response.PlayerResponse
import com.example.soccerapp.presentation.ui.theme.Gold
import com.example.soccerapp.presentation.ui.theme.Typography

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.PlayerCardItem(
    modifier: Modifier = Modifier,
    playerResponse: PlayerResponse,
    onClick: () -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    backgroundColor: Color = Gold,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val playerImage = playerResponse.player.img.orEmpty()
    val playerName = playerResponse.player.commonName?.substringBefore(",").orEmpty()
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .clickable { onClick() }
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = playerImage,
                contentDescription = "player_image",
                modifier = Modifier
                    .size(50.dp)
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = "image/$playerImage"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        boundsTransform = { _, _ ->tween(durationMillis = 1000) }
                    ),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "${playerResponse.number}  $playerName",
                modifier = Modifier
                    .weight(1f)
                    .sharedElement(
                        state = rememberSharedContentState(key = "name/$playerName"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        boundsTransform = { _, _ -> tween(durationMillis = 1000) }
                    ),
                style = Typography.titleMedium
            )
            IconButton(
                onClick = { expanded = !expanded },
                content = {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "expand_icon"
                    )
                }
            )
        }
        if (expanded)
            PlayerDetailSection(
                age = playerResponse.player.age ?: 0,
                weight = playerResponse.player.weight?.toInt() ?: 0,
                height = playerResponse.player.height?.toInt() ?: 0,
                countryName = playerResponse.player.country?.name.orEmpty(),
                position = playerResponse.position.getFormattedPlayerPosition(),
            )
    }
}