package com.ideasapp.messenger.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ideasapp.messenger.R
import com.ideasapp.messenger.presentation.ui.elements.startScreens.HeaderText

@Composable
@Preview
fun SignUpScreen() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.sign_up_image) ,
            contentDescription = stringResource(id = R.string.sign_up_image_description)
        )
        HeaderText(stringResource(id = R.string.sign_up))
    }
}