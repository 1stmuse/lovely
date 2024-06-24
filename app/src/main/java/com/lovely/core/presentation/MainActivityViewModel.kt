package com.lovely.core.presentation

import androidx.lifecycle.ViewModel
import com.lovely.auth_feature.data.local.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor (
    private val session: SessionManager
): ViewModel() {


    fun isLogin():Boolean {
        return  session.getAuthToken().isNotBlank()
    }
}