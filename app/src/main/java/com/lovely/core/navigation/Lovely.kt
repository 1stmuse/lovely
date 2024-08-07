package com.lovely.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.lovely.core.navigation.graphs.authGraph
import com.lovely.core.navigation.graphs.dashboardGraph
import com.lovely.core.navigation.graphs.onboardingGraph

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Lovely(
    startDestination: String
) {

    val navController = rememberNavController()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp)) {
        NavHost(navController = navController, startDestination = startDestination ){
            onboardingGraph(navController)
            authGraph(navController)
            dashboardGraph(navController)
        }
    }

}