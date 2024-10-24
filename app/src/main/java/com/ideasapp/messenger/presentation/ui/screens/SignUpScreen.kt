package com.ideasapp.messenger.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ideasapp.messenger.R
import com.ideasapp.messenger.presentation.ui.elements.startScreens.EmailField
import com.ideasapp.messenger.presentation.ui.elements.startScreens.HeaderText
import com.ideasapp.messenger.presentation.viewModel.SignUpViewModel

@Composable
fun SignUpScreen(email: String, onValueChange: (String) -> Unit) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.sign_up_image),
            contentDescription = stringResource(id = R.string.sign_up_image_description)
        )
        HeaderText(stringResource(id = R.string.sign_up))
        EmailField(email, onValueChange)
    }
}