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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lovely.auth.presentation.data.interest
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.AppButton


@Composable
fun Interest(navController: NavController) {
    var selectedInterest = remember {
        mutableStateListOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        {
            Row(
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
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Column(modifier = Modifier) {
                    Text(
                        text = "Skip",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Your interests",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Select a few of your interests and let everyone know what you’re passionate about.")
            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),

                ) {
                val rowLength = interest.data.size / 2
                val numOfColumn = 2
                for (row in 0..<rowLength) {
                    Column(
                        modifier = Modifier
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            for (col in 0..<numOfColumn){
                                val index = (numOfColumn * row) + col
                                val data = interest.data[index]
                                val isSelected = selectedInterest.contains(data.title)
                                Row(
                                    modifier = Modifier
                                        .width(160.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(color = if (isSelected) MaterialTheme.colorScheme.primary else Color.White)
                                        .border(
                                            width = if (isSelected) 0.dp else 0.4.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .clickable {
                                            if(isSelected){
                                                selectedInterest.remove(data.title)
                                            }else {
                                                selectedInterest.add(data.title)
                                            }

                                        }
                                        .padding(vertical = 6.dp)
                                        .padding(start = 13.dp)

                                        ,
                                    verticalAlignment = Alignment.CenterVertically,
//                                    horizontalArrangement = Arrangement.Absolute.Left
                                ) {
                                    Icon(
                                        painter = painterResource(id = data.icon),
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp),
                                        tint = if(isSelected) Color.White else MaterialTheme.colorScheme.primary,

                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(text = data.title,
                                         color = if(isSelected) Color.White else Color.Black,
//                                         modifier = Modifier.width(50.dp)
                                         )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(20.dp))


                    }

                }
            }
        }

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            AppButton(label = "Continue") {
                navController.navigate(Destinations.EnableNotification.route)
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}