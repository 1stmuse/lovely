package com.lovely.discover.presentation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.lovely.onboarding.component.onboardingItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(): ViewModel() {

    private val _cards = MutableStateFlow(onboardingItem)
     var cards = _cards.asStateFlow()

    fun onSwipe(event: DiscoverUIEvents){
        when(event) {
            is DiscoverUIEvents.OnSwipeLeft -> {
                swipedLeft(event.index)
            }

            is DiscoverUIEvents.OnSwipeRight -> {
                swipedRight(event.index)
            }
        }
    }

    private fun swipedLeft(index: Int){
        _cards.value = _cards.value.filter { it -> it.id != index }
    }

    private fun swipedRight(index: Int){
        _cards.value = _cards.value.filter { it -> it.id != index }
    }


}