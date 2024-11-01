package com.ideasapp.messenger.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
fun LoginScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onContinueButtonClick: () -> Unit,
    onSignUpTextClick: () -> Unit
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.login_image) ,
            contentDescription = stringResource(id = R.string.login_image_description) ,
            modifier = Modifier.padding(start = 40.dp, end = 28.dp, top = 60.dp)
        )
        HeaderText(stringResource(id = R.string.login))
        EmailField(email, onEmailChange)
        PasswordField(password, onPasswordChange)
        Button(
            onClick = { onContinueButtonClick() },
            modifier = Modifier
                .padding(top = 40.dp)
                .width(228.dp)
                .height(64.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(stringResource(id = R.string.continue_button))
        }
        Row (
            modifier = Modifier
                .padding(top = 40.dp, start = 100.dp)
        ) {
            Text(stringResource(id = R.string.is_new_user))
            Text(
                stringResource(id = R.string.sign_up),
                color = Color.Blue,
                modifier = Modifier
                .padding(start = 10.dp)
                .clickable { onSignUpTextClick() }
            )
        }
    }
}