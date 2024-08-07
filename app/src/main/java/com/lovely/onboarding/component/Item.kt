package com.lovely.onboarding.component
import com.lovely.R

data class Item(
    val image: Int,
    val label: String,
    val desc: String,
    val id: Int,
)

val onboardingItem = listOf<Item>(
    Item(
        image = R.drawable.onboard1,
        label = "Algorithm",
        desc = "Users going through a vetting process to ensure you never match with bots.",
        id = 0
    ),
    Item(
        image = R.drawable.onboard2,
        label = "Matches",
        desc = "We match you with people that have a\n" +
                "large array of similar interests.",
        id= 1,
    ),
    Item(
        image = R.drawable.onboard3,
        label = "Premium",
        desc = "Sign up today and enjoy the first month\n" +
                "of premium benefits on us.",
        id = 2
    ),
)
