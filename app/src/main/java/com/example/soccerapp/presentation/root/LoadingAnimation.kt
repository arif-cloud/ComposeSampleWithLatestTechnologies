package com.example.soccerapp.presentation.root

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.soccerapp.R

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    iconResource: Int = R.drawable.loading_icon,
    iconSize: Dp = 24.dp,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp,
    animationDuration: Int = 1200,
    delayBetween: Int = 100,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "LoadingAnimationTransition")
    val loadingIcons = List(3) { index ->
        infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = animationDuration
                    0.0f at 0 using  LinearOutSlowInEasing
                    1.0f at 300 using LinearOutSlowInEasing
                    0.0f at 600 using LinearOutSlowInEasing
                    0.0f at 1200 using LinearOutSlowInEasing
                },
                repeatMode = RepeatMode.Restart,
                initialStartOffset = StartOffset(index * delayBetween)
            ),
            label = "LoadingIconAnimation:$index"
        )
    }
    val distance = with(LocalDensity.current) { travelDistance.toPx() }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        loadingIcons.forEach { animatedValue ->
            Icon(
                imageVector = ImageVector.vectorResource(id = iconResource),
                contentDescription = "loading_icon",
                modifier = Modifier
                    .size(iconSize)
                    .graphicsLayer { translationY = -animatedValue.value * distance },
                tint = iconColor
            )
        }
    }
}