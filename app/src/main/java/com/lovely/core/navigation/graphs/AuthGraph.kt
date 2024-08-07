package com.lovely.core.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.lovely.auth.presentation.CreateProfileScreen
import com.lovely.auth.presentation.EnableNotificationScreen
import com.lovely.auth.presentation.GenderSelection
import com.lovely.auth.presentation.Interest
import com.lovely.auth.presentation.MobileAccess
import com.lovely.auth.presentation.SigninOptions
import com.lovely.auth.presentation.VerifyNumberScreen
import com.lovely.core.navigation.Destinations
import com.lovely.core.navigation.GraphsRoute


@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.authGraph(navController: NavHostController){

    navigation(startDestination = Destinations.SigninOptions.route, route = GraphsRoute.Auth){

        composable(route = Destinations.SigninOptions.route){
            SigninOptions(navController)
        }
        composable(Destinations.MobileAccess.route){
            MobileAccess(navController)
        }
        composable(Destinations.CreateProfile.route){
            CreateProfileScreen(navController)
        }
        composable(Destinations.GenderSelection.route){
            GenderSelection(navController = navController)
        }

        composable(Destinations.Interest.route){
            Interest(navController = navController)
        }
        composable(Destinations.EnableNotification.route){
            EnableNotificationScreen(navController = navController)
        }

        composable(Destinations.VerifyNumber.route){
            VerifyNumberScreen(navController = navController)
        }
    }
}