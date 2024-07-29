package com.lovely.discover.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt


@Composable
fun SwipeCard(
    threshold: Int = 200,
    sensitivity: Float = 2f,
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit,
    content: @Composable () -> Unit
) {

    var offset by remember { mutableFloatStateOf(0f) }
    var swipedLeft by remember { mutableStateOf(false) }
    var swipedRight by remember { mutableStateOf(false) }
    val density = LocalDensity.current.density

    LaunchedEffect(swipedLeft){
        if(swipedLeft){
            onSwipeLeft()
            swipedLeft = false
        }
    }

    LaunchedEffect(swipedRight){
        if(swipedRight){
            onSwipeRight()
            swipedRight = false
        }
    }

    Box(modifier = Modifier
        .offset { IntOffset(offset.roundToInt(), 0) }
        .pointerInput(Unit) {
            detectHorizontalDragGestures(onDragEnd = {
                offset = 0f
            }) { change, dragAmount ->
                offset += (dragAmount / density) * sensitivity

                when {
                    offset > threshold -> {
                        swipedRight = true
                    }

                    offset < -threshold -> {
                        swipedLeft = true
                    }
                }
                if (change.positionChange() != Offset.Zero) change.consume()
            }
        }
        .graphicsLayer(
            alpha = 10f - animateFloatAsState(if (swipedRight) 1f else 0f, label = "").value,
            rotationZ = animateFloatAsState(offset / 20, label = "").value
        )
    ){
        content()
    }

}