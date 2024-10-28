package com.lovely.auth.presentation

sealed class AuthUIEvents {

    class OnEditInput(val value: String): AuthUIEvents()
    data object OnSubmit: AuthUIEvents()

}