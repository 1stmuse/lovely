package com.lovely.core.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class Buttontype {
    PRIMARY,
    SECONDARY
}

@Composable
fun AppButton(
    label: String,
    variant: Buttontype = Buttontype.PRIMARY,
    onPress: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxWidth()
            .border(1.dp, color = if(variant == Buttontype.PRIMARY) Color.White else Color.LightGray, shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background( if(variant == Buttontype.PRIMARY) MaterialTheme.colorScheme.primary else Color.White)
            .clickable { onPress() }
            .padding(vertical = 15.dp)
        ,
        contentAlignment = Alignment.Center
    ) {
        Text(text = label, color = if(variant == Buttontype.PRIMARY) Color.White else MaterialTheme.colorScheme.primary)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPrev() {
    AppButton(label = "Create an account") {

    }
}