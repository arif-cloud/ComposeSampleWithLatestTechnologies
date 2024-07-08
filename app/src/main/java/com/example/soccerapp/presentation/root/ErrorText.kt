package com.example.soccerapp.presentation.root

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.soccerapp.presentation.ui.theme.Typography

@Composable
fun ErrorText(
    modifier: Modifier = Modifier,
    errorMessage: String
) {
    Text(
        text = errorMessage,
        color = Color.Red,
        modifier = modifier,
        style = Typography.titleMedium
    )
}