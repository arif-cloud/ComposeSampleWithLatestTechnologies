package com.example.soccerapp.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.soccerapp.R
import com.example.soccerapp.presentation.ui.theme.Blue
import com.example.soccerapp.presentation.ui.theme.Typography

@Composable
fun TeamItem(
    teamName: String,
    modifier: Modifier,
    onClick: () -> Unit,
    backgroundColor: Color = Blue
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.soccer_ball),
            contentDescription = "football_ball",
            modifier = Modifier.size(34.dp)
        )
        Text(
            text = teamName,
            style = Typography.titleMedium
        )
    }
}