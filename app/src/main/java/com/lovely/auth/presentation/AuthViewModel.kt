package com.lovely.auth.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel () : ViewModel() {
    private var _uiState = MutableStateFlow(AuthUIState())

    var uiState = _uiState.asStateFlow()
}