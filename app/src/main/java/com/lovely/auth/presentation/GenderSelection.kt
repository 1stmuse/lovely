package com.lovely.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.AppButton

val options = listOf("Woman", "Man", "Others")
@Composable
fun GenderSelection(navController: NavController) {
    val selectedOption = remember {
        mutableStateOf("Woman")
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable {
                        navController.popBackStack()
                    }
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Column(modifier = Modifier) {
                    Text(text = "Skip", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.headlineSmall)
                }
            }

            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "I am a", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(50.dp))

            options.forEach {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (selectedOption.value == it) MaterialTheme.colorScheme.primary else Color.White)
                        .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                        .clickable {
                            selectedOption.value = it
                        }
                        .padding(10.dp)
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = it, color = if(selectedOption.value == it) Color.White else Color.Black)
                    Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = if(selectedOption.value == it) Color.White else Color.Black )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            Spacer(modifier = Modifier.height(200.dp))
        }

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            AppButton(label = "Continue") {
                navController.navigate(Destinations.Interest.route)
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
   
}