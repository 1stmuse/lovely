package com.lovely.chat.presentation

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lovely.chat.ChatViewModel
import com.lovely.chat.presentation.component.ChatCard
import com.lovely.core.presentation.component.AppInput
import com.lovely.core.presentation.component.Space


@Composable
fun MessagesScreen(
    navController: NavController
) {

    val vm: ChatViewModel = hiltViewModel()
    var chats = vm.chatlist.collectAsState().value
    
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)
        .padding(top = 20.dp)){
        Column {
            Text(text = "Messages", fontSize = 26.sp, fontWeight = FontWeight.SemiBold)
            Space(height = 20.dp)
            AppInput(
                label = "Search",
                value = "",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(25.dp)
                    )
                },
                onChange = {}
            )
            Space(height = 20.dp)
            Column(
                modifier = Modifier.fillMaxHeight().verticalScroll(rememberScrollState()).padding(bottom = 100.dp)
            ) {
                chats.forEach {
                    ChatCard(item = it)
                }
            }
        }
    }
}