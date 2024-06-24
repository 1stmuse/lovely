package com.lovely.onboarding

import androidx.lifecycle.ViewModel
import com.lovely.auth_feature.data.local.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor (
    private val sessionManager: SessionManager
): ViewModel() {


    fun loginUser(){
        sessionManager.setAuthToken("dkfe7f84fn")
    }

}