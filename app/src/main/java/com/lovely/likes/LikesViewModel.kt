package com.lovely.likes

import androidx.lifecycle.ViewModel
import com.lovely.discover.data.ListUser
import com.lovely.discover.data.User
import com.lovely.discover.data.formattedUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LikesViewModel @Inject constructor(): ViewModel() {
    private val _users = MutableStateFlow<List<ListUser>>(emptyList())
    var users = _users.asStateFlow()

    init {
        _users.value = formattedUsers
    }
}