package com.example.soccerapp.presentation.player_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.soccerapp.presentation.ui.theme.Typography

@Composable
fun PlayerAttributes(
    modifier: Modifier = Modifier,
    attributes: List<Pair<String, String>>,
    spaceValueBetweenItems: Dp = 8.dp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(spaceValueBetweenItems)
        ) {
            attributes.forEach { (label, _) ->
                Text(text = label, style = Typography.bodyLarge)
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Divider(
            modifier = Modifier
                .height(140.dp)
                .width(1.dp),
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(spaceValueBetweenItems)
        ) {
            attributes.forEach { (_, value) ->
                Text(text = value, style = Typography.bodyLarge, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}