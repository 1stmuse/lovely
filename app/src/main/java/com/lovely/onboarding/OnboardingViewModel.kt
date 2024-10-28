package com.lovely.onboarding

import androidx.lifecycle.ViewModel
import com.lovely.auth.data.local.SessionManager


class OnboardingViewModel (
    private val sessionManager: SessionManager
): ViewModel() {


    fun loginUser(){
        sessionManager.setAuthToken("dkfe7f84fn")
    }

}