package com.example.lovely.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SwiperItem(
    image: Int,
    index:Int,
    currentIndex: Int
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(300.dp)
    ) {
        Image(painter = painterResource(id = image), contentDescription = null,
            modifier = Modifier
                .width(300.dp)
//                .height(400.dp)
                .height( if(index == currentIndex) 400.dp else 300.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))


    }

}