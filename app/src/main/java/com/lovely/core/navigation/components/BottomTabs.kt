package com.lovely.core.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lovely.core.navigation.BottomTabScreen
import com.lovely.core.navigation.Destinations
import com.lovely.ui.theme.BottomTabColor


@Composable
fun BottomTabs(
    tabs: List<BottomTabScreen>,
    selected: String,
    onClick: (route: String) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BottomTabColor),
        horizontalArrangement = Arrangement.Center
    ) {
         tabs.forEach {
             val selectedTab = selected == it.route
             Box(modifier = Modifier
                 .weight(1f)
                 .clickable { onClick(it.route) },
                   contentAlignment = Alignment.Center
             ) {
                 if(selectedTab){
                     Column(modifier = Modifier.height(4.dp).background(color = MaterialTheme.colorScheme.primary).width(30.dp).align(Alignment.TopCenter)){}
                 }

                 if(selectedTab){
                     Image(painter = painterResource(id = it.selectedIcon),
                           contentDescription = null,
                           modifier = Modifier.padding(10.dp).size(30.dp),)
                 }else {
                     Image(painter = painterResource(id = it.icon),
                           contentDescription = null,
                           modifier = Modifier.padding(10.dp).size(30.dp),)
                 }


             }
         }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomAtbPrev() {
    BottomTabs(tabs = listOf(
        BottomTabScreen.Discover,
        BottomTabScreen.Likes,
        BottomTabScreen.Chat,
        BottomTabScreen.Account
    ), selected = Destinations.Discover.route ){}
}