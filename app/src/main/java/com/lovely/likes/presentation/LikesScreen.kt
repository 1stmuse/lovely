package com.lovely.likes.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lovely.core.presentation.component.NoScrollGrid
import com.lovely.core.presentation.component.Space
import com.lovely.discover.data.formattedUsers
import com.lovely.discover.data.usersList
import com.lovely.likes.LikesViewModel
import com.lovely.likes.presentation.components.LikeCard


@Composable
fun LikesScreen(
    navController: NavController
) {

    val vm: LikesViewModel = hiltViewModel()
    val userList = vm.users.collectAsState().value

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)
        .padding(top = 20.dp)
    ){
         Text(text = "Matches", fontSize = 26.sp)
        Space(height = 10.dp)
        Text(text = "This is a list of people who have liked you and your matches.")
        Space(height = 10.dp)
        LazyColumn(modifier = Modifier.fillMaxHeight().padding(bottom = 50.dp)) {
            items(userList){ it ->
                NoScrollGrid(list = it.users) { user ->
//                    Text(text = user.name)
                   LikeCard(item = user)

                }
                Space(height = 20.dp)
            }
        }

    }
}