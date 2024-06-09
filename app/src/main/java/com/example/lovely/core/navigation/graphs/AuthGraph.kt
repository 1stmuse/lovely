package com.example.lovely.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lovely.auth_feature.presentation.MobileAccess
import com.example.lovely.auth_feature.presentation.SigninOptions
import com.example.lovely.core.navigation.Destinations
import com.example.lovely.core.navigation.GraphsRoute


fun NavGraphBuilder.authGraph(navController: NavHostController){

    navigation(startDestination = Destinations.SigninOptions.route, route = GraphsRoute.Auth){

        composable(route = Destinations.SigninOptions.route){
            SigninOptions(navController)
        }
        composable(Destinations.MobileAccess.route){
            MobileAccess(navController)
        }
    }
}