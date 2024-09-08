package com.lovely.chat.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lovely.chat.datasource.ChatModel
import com.lovely.core.presentation.component.Space


@Composable
fun ChatCard(
    item: ChatModel
) {


    Row (
        modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = item.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Space(width = 20.dp)
        Column(modifier = Modifier.weight(1f)) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier) {
                    Text(text = item.name, color = Color.Black, fontWeight = FontWeight.SemiBold)
                    Text(text = item.message, fontSize = 12.sp)
                }
                Column(modifier = Modifier) {
                    Text(text = "23 min", color = Color.Gray)
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.Center
                    ) {
                        Text(text = "1", color = Color.White)
                    }
                }
            }
            Space(height = 10.dp)
            Divider(thickness = 1.dp)
        }


    }
}