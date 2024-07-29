package com.lovely.discover.presentation

import android.util.Log
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lovely.core.presentation.component.Space
import com.lovely.discover.presentation.components.SwipeCard
import com.lovely.onboarding.component.onboardingItem
import kotlin.math.roundToInt

@Composable
fun Discover(navController: NavController) {
    val vm: DiscoverViewModel = hiltViewModel()
    val cards = vm.cards.collectAsState().value
//    var cards by remember { mutableStateOf(onboardingItem) }

    fun swipedRight(index: Int){

    }

    fun swipeLeft(index: Int){

    }


        Column(modifier = Modifier.fillMaxSize()
        ){
           Text(text = "Hello Swiper")
            Space(height = 40.dp)
            Box(modifier = Modifier.width(300.dp)){
                cards.forEachIndexed { index, item ->
                    SwipeCard(threshold = 400, sensitivity = 3f,
                              onSwipeLeft = { vm.onSwipe(DiscoverUIEvents.OnSwipeLeft(item.id)) },
                              onSwipeRight = { vm.onSwipe(DiscoverUIEvents.OnSwipeRight(item.id)) }) {
                        Image(painter = painterResource(id = item.image), contentDescription = null,
                              contentScale = ContentScale.Crop,
                              modifier = Modifier
//                                  .padding(horizontal = (index * 12).dp)
                                  .width(300.dp)
                                  .height(400.dp)
                                  .clip(RoundedCornerShape(16.dp))
//                                  .background(Color.Magenta)

//                                  .offset(x = 0.dp, y = if(index == 0) -10.dp else 0.dp)

                        )
                    }
                }
            }

        }

}