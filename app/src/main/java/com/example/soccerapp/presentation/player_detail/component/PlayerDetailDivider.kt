package com.example.soccerapp.presentation.player_detail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.soccerapp.R

@Composable
fun PlayerDetailDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.soccer_ball),
            contentDescription = "soccer_ball",
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .size(34.dp)
        )
        Divider(
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
    }
}