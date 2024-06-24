package com.lovely.core.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppInput(
    label: String,
    value: String,
    onChange: (value: String) -> Unit
) {

    OutlinedTextField(value = value, onValueChange = onChange,
        label = { Text(text = label)},
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
        ),
        shape = RoundedCornerShape(15.dp)
    )
}