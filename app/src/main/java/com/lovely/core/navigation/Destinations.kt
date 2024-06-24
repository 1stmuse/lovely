package com.lovely.core.navigation

object GraphsRoute {
    const val Onboarding = "ONBOARDING"
    const val Auth = "AUTH"
    const val Dashboard = "DASHBOARD"
}

sealed class Destinations(val route: String) {

    object Discover: Destinations("discover")
    object Onboarding: Destinations("onboarding")

//    AUTH
    object SigninOptions: Destinations("signin_options")
    object MobileAccess: Destinations("mobile_access")
    object CreateProfile: Destinations("create_profile")
    object GenderSelection: Destinations("gender_selection")
}