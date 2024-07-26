package com.lovely.core.navigation

object GraphsRoute {
    const val Onboarding = "ONBOARDING"
    const val Auth = "AUTH"
    const val Dashboard = "DASHBOARD"
}

const val TabRoute = "TAB"

sealed class Destinations(val route: String) {


    object Onboarding: Destinations("onboarding")

//    AUTH
    object SigninOptions: Destinations("signin_options")
    object MobileAccess: Destinations("mobile_access")
    object CreateProfile: Destinations("create_profile")
    object GenderSelection: Destinations("gender_selection")
    object Interest: Destinations("interest")
    object EnableNotification: Destinations("enable_notification")
    object VerifyNumber: Destinations("verify_number")

    //DASHBOARD ROUTES
    object Discover: Destinations("discover")
    object Likes: Destinations("likes")
    object Messages: Destinations("messages")
    object Account: Destinations("acoount")
}