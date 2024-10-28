package com.lovely.chat

import androidx.lifecycle.ViewModel
import com.lovely.chat.datasource.ChatModel
import com.lovely.chat.datasource.chatlistData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow



class ChatViewModel : ViewModel() {
    private var _chatList = MutableStateFlow(emptyList<ChatModel>())

    var chatlist = _chatList.asStateFlow()



    init {
        _chatList.value = chatlistData
    }
}