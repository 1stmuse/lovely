package com.lovely.core.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T>NoScrollGrid(
    list: List<T>,
    numberOfCol: Int = 2,
    content: @Composable (item: T) -> Unit
) {
    val evenDivision = list.size / numberOfCol
    val rowLength = if(list.size % numberOfCol == 0) evenDivision else evenDivision + 1

    for (row in 0..< rowLength){
        Column {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                 for (col in 0..<numberOfCol){
                     val index = (numberOfCol * row) + col
                     if(index < list.size){
                         content(list[index])
                     }

                 }
            }
        }
    }
}