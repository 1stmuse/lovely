package com.lovely.discover.presentation

sealed class DiscoverUIEvents {

    class OnSwipeLeft(val index: Int): DiscoverUIEvents()
    class OnSwipeRight(val index: Int): DiscoverUIEvents()
}