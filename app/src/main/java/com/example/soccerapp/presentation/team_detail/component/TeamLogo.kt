package com.example.soccerapp.presentation.team_detail.component

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun TeamLogo(
    modifier: Modifier = Modifier,
    logoImage: String
) {
    AsyncImage(
        model = logoImage,
        contentDescription = "logo_image",
        modifier = modifier
    )
}

@Preview
@Composable
private fun PrevTeamLogoCard() {
    TeamLogo(
        logoImage = "https://cdn.soccersapi.com/images/soccer/teams/100/111.png"
    )
}