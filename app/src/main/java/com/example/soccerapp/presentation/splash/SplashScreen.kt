package com.example.soccerapp.presentation.splash

import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.soccerapp.R
import com.example.soccerapp.presentation.root.Screen

@Composable
fun SplashScreen(
    navController: NavController,
) {
    val scale = remember { Animatable(0f) }
    LaunchedEffect(true) {
        scale.animateTo(
            targetValue = 0.8f,
            animationSpec = tween(
                durationMillis = 1400,
                easing = { BounceInterpolator().getInterpolation(it) }
            )
        )
        navController.navigate(Screen.Home) {
            popUpTo<Screen.Splash> {inclusive = true}
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "soccer_logo",
            modifier = Modifier
                .size(180.dp)
                .scale(scale.value)
        )
    }
}