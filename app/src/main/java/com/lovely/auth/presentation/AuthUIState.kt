package com.lovely.auth.presentation

data class LoginValues(val username: String = "",  val password: String = "")

data class AuthUIState(
    var inputState: LoginValues = LoginValues(),
    var loading: Boolean = false
)
