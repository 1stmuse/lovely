package com.lovely.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.lovely.core.navigation.GraphsRoute
import com.lovely.core.navigation.TabRoute
import com.lovely.core.navigation.TabScreens


fun NavGraphBuilder.dashboardGraph(
    navController: NavHostController
){

    navigation(TabRoute, GraphsRoute.Dashboard){

        composable(TabRoute){
            TabScreens(navController = navController)
        }
    }
}