package com.lovely.auth.presentation.data

import com.lovely.R

data class InterestData(
    val title: String,
    val icon: Int
)

object interest {
    val data = listOf<InterestData>(
        InterestData("Photography", R.drawable.photo),
        InterestData("Shopping", R.drawable.bag),
        InterestData("Karaoke", R.drawable.mic),
        InterestData("Yoga", R.drawable.yoga),
        InterestData("Cooking", R.drawable.noodles),
        InterestData("Tennis", R.drawable.tennis),
        InterestData("Run", R.drawable.sport),
        InterestData("Swimming", R.drawable.swim),
        InterestData("Art", R.drawable.platte),
        InterestData("Traveling", R.drawable.outdoor),
        InterestData("Extreme", R.drawable.parachute),
        InterestData("Music", R.drawable.music),
        InterestData("Drink", R.drawable.goblet_full),
        InterestData("Video games", R.drawable.game_handle),

    )
}