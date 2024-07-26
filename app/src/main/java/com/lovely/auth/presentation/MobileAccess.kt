package com.lovely.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lovely.core.navigation.Destinations
import com.lovely.core.presentation.component.AppButton
import com.lovely.core.presentation.component.AppInput

@Composable
fun MobileAccess(navController: NavController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)) {
        Spacer(modifier = Modifier.height(120.dp))
        Text(text = "My mobile", style = MaterialTheme.typography.titleLarge)
        Text(
            text = "Please enter your valid phone number. We will send you a 4-digit code to verify your account.",
            modifier = Modifier.padding(top = 5.dp), style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(20.dp))
        AppInput(label = "number", value = ""){}
        Spacer(modifier = Modifier.height(40.dp))
        AppButton(label = "Continue") {
            navController.navigate(Destinations.VerifyNumber.route)
        }
    }
}