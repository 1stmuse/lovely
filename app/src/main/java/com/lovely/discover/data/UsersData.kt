package com.lovely.discover.data

import com.lovely.R
import com.lovely.onboarding.component.Item


data class User(
    val image: String,
    val name: String,
    val age: Int,
    val id: Int,
    val occupation: String? = "",
    val distance: String? = "1km"
)

val usersList = listOf<User>(
    User(
        image = "https://images.pexels.com/photos/1391498/pexels-photo-1391498.jpeg?cs=srgb&dl=pexels-soldiervip-1391498.jpg&fm=jpg",
        name = "Jesicca Nairo",
        age = 22,
        id = 0,
        occupation = "Footballer"
    ),
    User(
        image = "https://c4.wallpaperflare.com/wallpaper/834/501/318/images-girl-1920x1200-wallpaper-preview.jpg",
        name = "Samanta Smith",
        age = 40,
        id= 1,
        occupation = "Masseuse"
    ),
    User(
        image = "https://qph.cf2.quoracdn.net/main-qimg-fb51c273557a67f5a98aa85d1f389f7b",
        name = "Grace Abel",
        age = 27,
        id = 2,
        occupation = "escort"
    )
)

data class ListUser(
    val date: String,
    val users: List<User>
)


val formattedUsers = listOf<ListUser>(
    ListUser("Today", users = usersList),
    ListUser("Yesterday", users = usersList.reversed()),
)