package com.example.soccerapp.presentation.team_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.soccerapp.R
import com.example.soccerapp.presentation.ui.theme.Typography

@Composable
fun PlayerDetailSection(
    modifier: Modifier = Modifier,
    age: Int,
    weight: Int,
    height: Int,
    countryName: String,
    position: String,
) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AnimatedCircularIndicator(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            value = age,
            maxValue = 50,
            label = "Age"
        )
        AnimatedCircularIndicator(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            value = weight,
            maxValue = 140,
            label = "Weight"
        )
        AnimatedCircularIndicator(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            value = height,
            maxValue = 220,
            label = "Height"
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.country),
                contentDescription = "country_icon"
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = countryName, style = Typography.bodyLarge)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.position),
                contentDescription = "position_icon"
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = position, style = Typography.bodyLarge)
        }
        Spacer(modifier = Modifier.weight(1f))
    }
    Spacer(modifier = Modifier.height(10.dp))
}