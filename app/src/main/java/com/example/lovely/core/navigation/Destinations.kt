package com.example.lovely.core.navigation

object GraphsRoute {
    const val Onboarding = "ONBOARDING"
    const val Auth = "AUTH"
    const val Dashboard = "DASHBOARD"
}

sealed class Destinations(val route: String) {

    object Discover: Destinations("discover")
    object Onboarding: Destinations("onboarding")
}