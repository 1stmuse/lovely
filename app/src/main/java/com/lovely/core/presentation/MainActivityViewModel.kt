package com.lovely.core.presentation

import androidx.lifecycle.ViewModel
import com.lovely.auth_feature.data.local.SessionManager
import com.lovely.core.navigation.GraphsRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor (
    private val session: SessionManager
): ViewModel() {

     private var _startDestination = MutableStateFlow<String>(GraphsRoute.Onboarding)


    var startDestination = _startDestination.asStateFlow()

    init {
        if(isLogin().isNotBlank() && hasId().isNotBlank() ){
            _startDestination.value = GraphsRoute.Dashboard
        } else if (hasId().isBlank()){
            _startDestination.value = GraphsRoute.Auth
        }else {
            _startDestination.value = GraphsRoute.Onboarding
        }
    }


    private fun isLogin():String = session.getAuthToken()

    private fun hasId(): String = session.getUserId()
}