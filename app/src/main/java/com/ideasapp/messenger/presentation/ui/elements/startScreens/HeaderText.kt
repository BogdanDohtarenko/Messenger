package com.ideasapp.messenger.presentation.ui.elements.startScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp, // Set the desired font size
        fontWeight = FontWeight.Bold // Set text to bold
    )
}