package com.lovely.discover.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lovely.R

@Composable
fun DiscoverHeader(
    location: String? = "",
    onPressFilter: () -> Unit
) {

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .size(40.dp)
            .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
            ) {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                 contentDescription = null,
                 tint = MaterialTheme.colorScheme.primary,
                 modifier = Modifier.size(25.dp)
            )

        }
        Column(modifier = Modifier) {
            Text(text = "Discover", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = location!!)
        }
        Box(modifier = Modifier
            .size(40.dp)
            .clickable { onPressFilter() }
            .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center) {
            Icon(painter = painterResource(id = R.drawable.setting),
                 contentDescription = null,
                 modifier = Modifier.size(25.dp),
                 tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}