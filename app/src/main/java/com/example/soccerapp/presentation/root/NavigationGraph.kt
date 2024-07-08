package com.example.soccerapp.presentation.root

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.soccerapp.presentation.home.HomeScreen
import com.example.soccerapp.presentation.player_detail.PlayerDetailScreen
import com.example.soccerapp.presentation.splash.SplashScreen
import com.example.soccerapp.presentation.team_detail.TeamDetailScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    SharedTransitionLayout {
        NavHost(
            navController = navHostController,
            startDestination = Screen.Splash,
            modifier = modifier
        ) {
            composable<Screen.Splash> {
                SplashScreen(navController = navHostController)
            }
            composable<Screen.Home>(
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up,
                        animationSpec = tween(700)
                    )
                }
            ) {
                HomeScreen(navController = navHostController)
            }
            composable<Screen.TeamDetailScreen>(
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }
            ) {
                val args = it.toRoute<Screen.TeamDetailScreen>()
                TeamDetailScreen(
                    teamId = args.teamId,
                    navController = navHostController,
                    animatedVisibilityScope = this@composable
                )
            }
            composable<Screen.PlayerDetailScreen> {
                val args = it.toRoute<Screen.PlayerDetailScreen>()
                PlayerDetailScreen(
                    playerId = args.playerId,
                    imageUrl = args.imageUrl,
                    playerName = args.playerName,
                    navController = navHostController,
                    animatedVisibilityScope = this@composable
                )
            }
        }
    }
}