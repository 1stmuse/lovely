package com.lovely.chat

import androidx.lifecycle.ViewModel
import com.lovely.chat.datasource.ChatModel
import com.lovely.chat.datasource.chatlistData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(): ViewModel() {
    private var _chatList = MutableStateFlow(emptyList<ChatModel>())

    var chatlist = _chatList.asStateFlow()



    init {
        _chatList.value = chatlistData
    }
}