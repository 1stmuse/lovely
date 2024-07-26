package com.lovely.auth.presentation

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lovely.R
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.Space

val keys = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "C")

@Composable
fun VerifyNumberScreen(navController: NavController) {
    val otp = remember {
        mutableStateOf("")
    }

    fun onPress(value: String){

        if(value == "C" && otp.value.isNotEmpty()){
            otp.value = otp.value.slice(0..<otp.value.length - 1)
            Log.d("OTP", otp.value)
            return
        }

        if(otp.value.length == 4){
            return
        }else {
            otp.value = otp.value + value
            Log.d("OTP", otp.value)
        }
    }

    LaunchedEffect(key1 = otp.value){
        if(otp.value.length == 4){
            navController.navigate(Destinations.CreateProfile.route)
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row (
                modifier = Modifier.fillMaxWidth()
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
                        modifier = Modifier.size(40.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            
            Text(text = "00:42", fontSize = 20.sp,
                 textAlign = TextAlign.Center,
                 fontWeight = FontWeight.Bold,
                 modifier = Modifier.fillMaxWidth()
            )
            Space(height = 10.dp)
            Text(text = "Type the verification code we’ve sent you",
                 textAlign = TextAlign.Center,
                 modifier = Modifier
                     .width(200.dp)
                     .align(Alignment.CenterHorizontally),
            )
            Space(height = 30.dp)
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 0..<4){
                    val hasValue = otp.value.length > i
                    Box(modifier = Modifier
                        .size(80.dp)
                        .border(
                            width = 1.dp,
                            color = if (hasValue) MaterialTheme.colorScheme.primary else Color.LightGray,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = if (hasValue) MaterialTheme.colorScheme.primary else Color.White)
                        ,
                        contentAlignment = Alignment.Center
                        ){
                        Text(text = if (hasValue) "${otp.value[i]}" else "0",
                             fontSize = 20.sp,
                             color = if(hasValue) Color.White else Color.Gray,
                             fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Space(height = 70.dp)
            Column(
                modifier = Modifier.fillMaxWidth(),

                ) {
                val numOfColumn = 3
                val rowLength = keys.size / numOfColumn
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
                                val data = keys[index]

                                Row(
                                    modifier = Modifier
                                        .width(60.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .clickable { onPress(data) }
                                        .padding(vertical = 10.dp)


                                    ,
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    if(data == "C"){
                                       Icon(painter = painterResource(id = R.drawable.ic_backspace),
                                            contentDescription = null,
                                            modifier = Modifier.width(20.dp)
                                       )
                                    }else {
                                        Text(text = data, color = Color.Black, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                }
            }
        }

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Send again",
                 modifier = Modifier
                     .clickable { }
                     .padding(10.dp),
                 color = MaterialTheme.colorScheme.primary,
                 fontWeight = FontWeight.Bold
            )
            Space(height = 30.dp)
        }

    }
}