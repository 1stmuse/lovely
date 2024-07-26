package com.lovely.core.navigation

import com.lovely.R

sealed class BottomTabScreen(
    val route: String, val icon: Int, val selectedIcon: Int
) {

    object Discover: BottomTabScreen(Destinations.Discover.route, R.drawable.cards, R.drawable.cards_tint)
    object Likes: BottomTabScreen(Destinations.Likes.route, R.drawable.like, R.drawable.like_tint)
    object Chat: BottomTabScreen(Destinations.Messages.route, R.drawable.message, R.drawable.message_tint)
    object Account: BottomTabScreen(Destinations.Account.route, R.drawable.people, R.drawable.apple)
}