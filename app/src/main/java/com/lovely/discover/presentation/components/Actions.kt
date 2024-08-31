package com.lovely.discover.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.unit.dp

@Composable
fun Actions() {

    Row (
        modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
         Box(modifier = Modifier.size(50.dp)
             .shadow(12.dp,

                     shape = CircleShape,
                     spotColor = DefaultShadowColor,
                     clip = true
             )
             .clip(CircleShape)
             .background(Color.White),
             contentAlignment = Alignment.Center
         ){
             Icon(imageVector = Icons.Default.Close, contentDescription = null,
                  modifier = Modifier.size(20.dp),
                  tint = MaterialTheme.colorScheme.primary
             )
         }
        Box(modifier = Modifier.size(70.dp)
            .shadow(15.dp,
//                    ambientColor = MaterialTheme.colorScheme.primary,
                    shape = CircleShape,
                    spotColor = MaterialTheme.colorScheme.primary,
                    clip = true
            )
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            ,
            contentAlignment = Alignment.Center
        ){
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null,
                 modifier = Modifier.size(40.dp),
                 tint = Color.White
            )
        }
        Box(modifier = Modifier.size(50.dp)
            .shadow(12.dp,
                    shape = CircleShape,
                    spotColor = DefaultShadowColor,
                    clip = true
            )
            .clip(CircleShape)
            .background(Color.White),
            contentAlignment = Alignment.Center
        ){
            Icon(imageVector = Icons.Default.Star, contentDescription = null,
                 modifier = Modifier.size(20.dp),
                 tint = Color.Magenta
            )
        }
    }
}