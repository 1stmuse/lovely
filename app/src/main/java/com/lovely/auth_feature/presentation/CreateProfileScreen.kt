package com.lovely.auth_feature.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lovely.R
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.AppButton
import com.lovely.core.presentation.component.AppInput
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.StaticCalendar
import io.github.boguszpawlowski.composecalendar.rememberCalendarState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.YearMonth

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateProfileScreen(
    navController: NavController
) {

    val calendarState = rememberSelectableCalendarState(initialSelectionMode = SelectionMode.Single )
    val showModalSheet = remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)) {
        Text("Skip", color= MaterialTheme.colorScheme.primary, fontSize = 19.sp,
            modifier = Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Profile Details", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
            Image(painter = painterResource(id = R.drawable.face), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Column(modifier = Modifier
                .offset(x = 75.dp, y = 75.dp)
                .height(30.dp)
                .width(30.dp)
                .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                .border(2.dp, color = Color.White, shape = CircleShape)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Icon(painter = painterResource(id = R.drawable.ic_camera), contentDescription = null, tint = Color.White,
                    modifier = Modifier
                        .width(15.dp)
                        .height(15.dp)
                    )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        AppInput(label = "First name", value = ""){}
        Spacer(modifier = Modifier.height(10.dp))
        AppInput(label = "Last name", value = ""){}
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.onPrimary)
                .clickable {
                    showModalSheet.value = true
                }
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
           Icon(imageVector = Icons.Default.DateRange, contentDescription = null,
               tint = MaterialTheme.colorScheme.primary
           )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Choose birthday date", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(50.dp))
        AppButton(label = "Confirm") {
            navController.navigate(Destinations.GenderSelection.route)
        }

        if(showModalSheet.value){
            ModalBottomSheet(onDismissRequest = {
                showModalSheet.value = !showModalSheet.value
            },
                sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
                modifier = Modifier
                    .padding(bottom = 20.dp),
                containerColor = Color.White

//                    .height(500.dp)
                ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)) {
                    SelectableCalendar(
                        calendarState = calendarState,
                        daysOfWeekHeader = {},
                        dayContent = {dayState ->
                            val selectionState = calendarState.selectionState
                            val isSelected = selectionState.isDateSelected(dayState.date)

                            Column(modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                                .padding(all = 5.dp)
                                .clip(CircleShape)
                                .background(color = if (isSelected) MaterialTheme.colorScheme.primary else Color.White)
                                .clickable {
                                    selectionState.onDateSelected(dayState.date)
                                }
                                ,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = dayState.date.dayOfMonth.toString(), color = if(isSelected) Color.White else Color.Black, style = MaterialTheme.typography.bodyLarge)

                            } },
                        monthHeader = { monthState ->
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null,
                                    modifier = Modifier.clickable {
                                        calendarState.monthState.currentMonth = calendarState.monthState.currentMonth.minusMonths(1)
                                    }
                                )
                                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = "Birthday")
                                    Text(text = calendarState.monthState.currentMonth.year.toString(),
                                        style = MaterialTheme.typography.headlineLarge,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = calendarState.monthState.currentMonth.month.name.lowercase().replaceFirstChar { it.uppercase() },
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null,
                                    modifier = Modifier.clickable {
                                        calendarState.monthState.currentMonth = calendarState.monthState.currentMonth.plusMonths(1)
                                    }
                                )
                            }
                        },
                        modifier = Modifier.animateContentSize(),
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    AppButton(label = "Save") {
                        showModalSheet.value = false
                    }
                    Spacer(modifier = Modifier.height(45.dp))
                }
            }
        }


    }
}