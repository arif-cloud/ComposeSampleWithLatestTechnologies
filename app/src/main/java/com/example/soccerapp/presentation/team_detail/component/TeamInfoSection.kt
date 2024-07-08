package com.example.soccerapp.presentation.team_detail.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.soccerapp.domain.model.TeamDetail
import com.example.soccerapp.presentation.ui.theme.Typography

@Composable
fun TeamInfoSection(
    modifier: Modifier = Modifier,
    teamDetail: TeamDetail?,
) {
    val animateBlur = remember { Animatable(20f) }
    LaunchedEffect(key1 = Unit) {
        animateBlur.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 2000, easing = FastOutSlowInEasing)
        )
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamLogo(
            modifier = Modifier
                .size(120.dp)
                .blur(animateBlur.value.dp),
            logoImage = teamDetail?.img ?: ""
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = teamDetail?.name.orEmpty(),
                style = Typography.titleLarge
            )
            Text(
                text = "${teamDetail?.leagues?.firstOrNull()?.name} - ${teamDetail?.country?.name}",
                style = Typography.labelMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevTeamInfoSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamLogo(
            logoImage = ""
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = "Real Madrid", style = Typography.titleLarge)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "La Liga - Spain", style = Typography.labelMedium)
        }
    }
}