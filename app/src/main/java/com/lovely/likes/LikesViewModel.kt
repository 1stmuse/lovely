package com.lovely.likes

import androidx.lifecycle.ViewModel
import com.lovely.discover.data.ListUser
import com.lovely.discover.data.User
import com.lovely.discover.data.formattedUsers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class LikesViewModel : ViewModel() {
    private val _users = MutableStateFlow<List<ListUser>>(emptyList())
    var users = _users.asStateFlow()

    init {
        _users.value = formattedUsers
    }
}