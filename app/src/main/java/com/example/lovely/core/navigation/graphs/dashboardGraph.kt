package com.example.lovely.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lovely.core.navigation.Destinations
import com.example.lovely.core.navigation.GraphsRoute
import com.example.lovely.discover_feature.presentation.Discover


fun NavGraphBuilder.dashboardGraph(
    navController: NavHostController
){
    navigation(Destinations.Discover.route, GraphsRoute.Dashboard){

        composable(Destinations.Discover.route){
            Discover(navController)
        }
    }
}