package com.example.lovely.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lovely.core.navigation.Destinations
import com.example.lovely.core.navigation.GraphsRoute
import com.example.lovely.onboarding.OnBoarding


fun NavGraphBuilder.onboardingGraph(
    navController: NavHostController
) {

    navigation(
        startDestination = Destinations.Onboarding.route,
        route = GraphsRoute.Onboarding
    ){
        composable(route = Destinations.Onboarding.route){
            OnBoarding()
        }
    }
}