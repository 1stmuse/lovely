package com.lovely.likes.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.lovely.core.util.CONSTANTS
import com.lovely.core.util.getAverageColor
import com.lovely.discover.data.User

@Composable
fun LikeCard(
    item: User
) {
    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(item.image)
            .size(Size.ORIGINAL)
            .build()
    ).state

    val defaultColor = MaterialTheme.colorScheme.secondaryContainer
    var dominantColor by remember {
        mutableStateOf(defaultColor)
    }
    
    Box(modifier = Modifier
        .width(160.dp)
//        .height(250.dp)
        .padding(bottom = 20.dp)
        .clip(RoundedCornerShape(10.dp))
         ){
        when(imageState){
            is AsyncImagePainter.State.Loading,
            is AsyncImagePainter.State.Empty,
            is AsyncImagePainter.State.Error -> {
                AsyncImage(
                    model = CONSTANTS.DEFAULT_IMAGE,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(160.dp)
                        .height(250.dp)
                )
            }

            is AsyncImagePainter.State.Success -> {
                dominantColor = getAverageColor(imageBitmap = imageState.result.drawable.toBitmap().asImageBitmap())
                Image(
                    painter = imageState.painter,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(160.dp)
                        .height(250.dp)
                )
            }
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .align(Alignment.BottomStart)) {
            Text(text = "${item.name}, ${item.age}")
            Box(modifier = Modifier){
                Row (
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(dominantColor.copy(alpha = 0.7f))
                        .blur(30.dp)
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){}
                Row (
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(imageVector = Icons.Default.Close,
                         contentDescription = null,
                         tint = Color.White,
                         modifier = Modifier.size(20.dp)
                    )
                    Divider(modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp), thickness = 2.dp)
                    Icon(imageVector = Icons.Default.Favorite,
                         contentDescription = null,
                         tint = Color.White,
                         modifier = Modifier.size(20.dp)
                    )
                }
            }

        }

    }
}