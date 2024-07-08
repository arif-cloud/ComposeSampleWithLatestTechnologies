package com.example.soccerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.soccerapp.presentation.root.NavigationGraph
import com.example.soccerapp.presentation.ui.theme.SoccerAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoccerAppTheme {
                val navController = rememberNavController()
                Scaffold {
                    NavigationGraph(
                        modifier = Modifier.padding(it),
                        navHostController = navController
                    )
                }
            }
        }
    }
}