package com.example.soccerapp.presentation.team_detail.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.soccerapp.presentation.ui.theme.Typography
import com.example.soccerapp.presentation.ui.theme.White

@Composable
fun AnimatedCircularIndicator(
    modifier: Modifier = Modifier,
    value: Int,
    maxValue: Int,
    label: String,
    progressIndicatorColor: Color = White,
    progressBackgroundColor: Color = Color.LightGray,
) {
    val stroke = with(LocalDensity.current) {
        Stroke(width = 6.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
    }
    val animateFloat = remember { Animatable(0f) }
    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = value / maxValue.toFloat(),
            animationSpec = tween(durationMillis = 2000, easing = FastOutSlowInEasing)
        )
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = value.toString(), style = Typography.titleLarge)
            Text(text = label, style = Typography.labelSmall)
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            val startAngle = 270f
            val sweep: Float = animateFloat.value * 360f
            val diameterOffset = stroke.width / 2
            drawCircle(
                color = progressBackgroundColor,
                style = stroke,
                radius = size.minDimension / 2 - diameterOffset
            )
            drawArc(
                color = progressIndicatorColor,
                startAngle = startAngle,
                sweepAngle = sweep,
                useCenter = false,
                topLeft = Offset(diameterOffset, diameterOffset),
                size = Size(size.width - 2 * diameterOffset, size.height - 2 * diameterOffset),
                style = stroke
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevAnimatedCircularIndicator() {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            AnimatedCircularIndicator(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                value = 84,
                maxValue = 140,
                label = "Weight",
                progressIndicatorColor = Color.Green
            )
            Spacer(modifier = Modifier.width(20.dp))
            AnimatedCircularIndicator(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                value = 180,
                maxValue = 210,
                label = "Height",
                progressIndicatorColor = Color.Blue
            )
        }
    }
}