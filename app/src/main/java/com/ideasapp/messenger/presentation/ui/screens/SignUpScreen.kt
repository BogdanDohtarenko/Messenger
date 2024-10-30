package com.ideasapp.messenger.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ideasapp.messenger.R
import com.ideasapp.messenger.presentation.ui.elements.startScreens.EmailField
import com.ideasapp.messenger.presentation.ui.elements.startScreens.HeaderText
import com.ideasapp.messenger.presentation.ui.elements.startScreens.PasswordField
import com.ideasapp.messenger.presentation.ui.elements.startScreens.UsernameField


@Composable
fun SignUpScreen(
    email: String,
    username: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onBackButtonClick: () -> Unit,
    onContinueButtonClick: () -> Unit
) {
    Column {
        Row {
            Button(
                onClick = { onBackButtonClick() },
                colors = ButtonColors(Color.White, Color.White, Color.DarkGray, Color.DarkGray) ,
                modifier = Modifier
                    .padding(top = 60.dp)
                    .width(70.dp)
                    .height(70.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = stringResource(id = R.string.arrow_image_description),
                    modifier = Modifier.fillMaxSize()
                )
            }
            Image(
                painter = painterResource(id = R.drawable.sign_up_image),
                contentDescription = stringResource(id = R.string.sign_up_image_description),
                modifier = Modifier.padding(start = 0.dp, end = 28.dp, top = 60.dp)
            )
        } //
        HeaderText(stringResource(id = R.string.sign_up))
        EmailField(email, onEmailChange)
        UsernameField(username, onUsernameChange)
        PasswordField(password, onPasswordChange)
        Button(
            onClick = { onContinueButtonClick() },
            modifier = Modifier
                .padding(top = 60.dp)
                .width(228.dp)
                .height(64.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(id = R.string.continue_button))
        }
    }
}