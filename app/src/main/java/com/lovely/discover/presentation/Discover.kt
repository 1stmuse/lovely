package com.lovely.discover.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.lovely.core.presentation.component.AppButton
import com.lovely.core.presentation.component.Space
import com.lovely.discover.presentation.components.Actions
import com.lovely.discover.presentation.components.DiscoverHeader
import com.lovely.discover.presentation.components.SwipeCard

val tabs = listOf<String>("Girls", "Boys", "Both")
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun Discover(navController: NavController) {
    var showFilter by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableStateOf(tabs[0]) }

    var distanceRange by remember { mutableFloatStateOf(0f) }
    var ageRange by remember { mutableStateOf(0f..60f)}

    val vm: DiscoverViewModel = hiltViewModel()
    val cards = vm.cards.collectAsState().value

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
        ){
            Space(height = 10.dp)
            Column {
                DiscoverHeader(location = "Chicago, II") {
                    showFilter = true
                }
                Space(height = 40.dp)

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    cards.forEachIndexed { _, item ->
                        SwipeCard(threshold = 400, sensitivity = 3f,
                                  onSwipeLeft = { vm.onSwipe(DiscoverUIEvents.OnSwipeLeft(item.id)) },
                                  onSwipeRight = { vm.onSwipe(DiscoverUIEvents.OnSwipeRight(item.id)) }) {
                            Box(modifier = Modifier){
                                AsyncImage(
                                    model = item.image,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .width(300.dp)
                                        .height(450.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                )
                            }

                        }
                    }
                }
            }

           Column(modifier = Modifier.align(Alignment.BottomCenter)) {
               Actions()
               Space(height = 100.dp)
           }

            if(showFilter){
                ModalBottomSheet(
                    onDismissRequest = { showFilter = false },
                    dragHandle = {},
                    sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .background(Color.White)
                        .padding(horizontal = 20.dp)) {
                        Box(modifier = Modifier.fillMaxWidth()){
                            Text(text = "Filters", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, modifier = Modifier.align(
                                Alignment.TopCenter))
                            Text(text = "Clear", color=MaterialTheme.colorScheme.primary,
                                 fontWeight = FontWeight.Bold,
                                 modifier = Modifier
                                     .align(Alignment.TopEnd)
                                     .padding(top = 8.dp), style = MaterialTheme.typography.titleMedium)
                        }
                        Space( height = 30.dp)
                        Text(text = "Interested in", fontWeight = FontWeight.Bold)
                        Space( height = 10.dp)
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .border(width = 0.5.dp, color = Color.Gray)
                        ) {
                            tabs.forEach {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .background(if (selectedTab == it) MaterialTheme.colorScheme.primary else Color.White)
                                        .clickable { selectedTab = it }
                                        .padding(vertical = 10.dp)
                                        ,
                                ) {
                                    Text(text = it,
                                         modifier = Modifier.align(Alignment.Center),
                                         color = if(selectedTab == it) Color.White else Color.Black
                                    )
                                }
                            }
                        }
                        Space( height = 30.dp)
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                             Text(text = "Distance", fontWeight = FontWeight.Bold)
                            Text(text = "${distanceRange}km")
                        }
                        Space( height = 10.dp)
                        Slider(
                            value = distanceRange,
                            onValueChange = { distanceRange = it },
                            colors = SliderDefaults.colors(
                                thumbColor = MaterialTheme.colorScheme.primary,
                                activeTrackColor = MaterialTheme.colorScheme.primary,
                                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                            ),
                            steps = 3,
                            valueRange = 0f..50f
                        )
                        Space( height = 30.dp)
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Age", fontWeight = FontWeight.Bold)
                            Text(text = "${ageRange.start.toInt()}-${ageRange.endInclusive.toInt()}")
                        }
                        Space( height = 10.dp)
                        RangeSlider(
                            value = ageRange,
                            steps = 5,
                            onValueChange = { range -> ageRange = range },
                            valueRange = 0f..60f,
                            onValueChangeFinished = {
                                // launch some business logic update with the state you hold
                                // viewModel.updateSelectedSliderValue(sliderPosition)
                            },
                        )
                        Space( height = 30.dp)
                        AppButton(label = "Continue") {

                        }
                    }


                }
            }




        }

}