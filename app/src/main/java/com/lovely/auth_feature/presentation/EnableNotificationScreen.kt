package com.lovely.auth_feature.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lovely.R
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.AppButton


@Composable
fun EnableNotificationScreen(
    navController: NavController
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)){
        Column(modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(top = 20.dp)) {
            Text(text = "Skip", color= MaterialTheme.colorScheme.primary)
        }
        Column(modifier = Modifier.align(Alignment.Center)) {
            Column(modifier = Modifier,
                   horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                Image(
                    painter = painterResource(id = R.drawable.chat), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Enable notifications", textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Get push-notification when you get the match or receive a message.",
                    textAlign = TextAlign.Center
                )
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