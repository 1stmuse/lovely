package com.lovely.core.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lovely.account.presentation.AccountScreen
import com.lovely.chat.presentation.MessagesScreen
import com.lovely.core.navigation.components.BottomTabs
import com.lovely.discover.presentation.Discover
import com.lovely.likes.presentation.LikesScreen

@Composable
fun TabScreens(
    navController: NavController
) {

    val bottomNavController = rememberNavController()
    val tabs = listOf<BottomTabScreen>(
        BottomTabScreen.Discover,
        BottomTabScreen.Likes,
        BottomTabScreen.Chat,
        BottomTabScreen.Account
    )

    val currentScreen = bottomNavController.currentScreenAsState()
    
    Scaffold(
        bottomBar = {
            BottomTabs(tabs = tabs, selected = currentScreen, onClick = {
                bottomNavController.navigate(it){
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(bottomNavController.graph.findStartDestination().id){
                        saveState = true
                    }
                }
            } )
        }
    ) {

        val padding = it
        NavHost(navController = bottomNavController , startDestination = Destinations.Discover.route ) {
            composable(Destinations.Discover.route){
                Discover(navController = navController)
            }

            composable(Destinations.Likes.route){
                LikesScreen(navController = navController)
            }

            composable(Destinations.Messages.route){
                MessagesScreen(navController = navController)
            }

            composable(Destinations.Account.route){
                AccountScreen(navController = navController)
            }
        }
    }
}

@Stable
@Composable
private fun NavController.currentScreenAsState(): String{
    val selectedItem = remember {
        mutableStateOf(Destinations.Discover.route)
    }

    DisposableEffect(key1 = this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            selectedItem.value = destination.route!!
        }

        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return selectedItem.value
}