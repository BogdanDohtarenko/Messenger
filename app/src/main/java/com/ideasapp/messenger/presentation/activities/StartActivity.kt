package com.ideasapp.messenger.presentation.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.ideasapp.messenger.presentation.ui.screens.StartScreen
import com.ideasapp.messenger.presentation.ui.theme.MessengerTheme
import com.ideasapp.messenger.presentation.viewModel.SignUpLoginViewModel


class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: SignUpLoginViewModel = ViewModelProvider(this)[SignUpLoginViewModel::class.java]

        setContent {
            //TODO watch videos
            MessengerTheme {
                val emailState = viewModel.email.observeAsState("")
                val usernameState = viewModel.username.observeAsState("")
                val passwordState = viewModel.password.observeAsState("")
                val errorEmailState = viewModel.errorEmail.observeAsState(false)
                val errorUsernameState = viewModel.errorUsername.observeAsState(false)
                val errorPasswordState = viewModel.errorPassword.observeAsState(false)
                StartScreen(
                    emailState.value,
                    usernameState.value,
                    passwordState.value,
                    errorEmailState.value,
                    errorUsernameState.value,
                    errorPasswordState.value,
                    onEmailChange = { email ->
                        viewModel.resetEmailError()
                        viewModel.onEmailChange(email)
                    },
                    onUsernameChange = { username ->
                        viewModel.resetUsernameError()
                        viewModel.onUsernameChange(username)
                    },
                    onPasswordChange = { password ->
                        viewModel.resetPasswordError()
                        viewModel.onPasswordChange(password)
                    },
                    onContinueLoginButtonClick = {
                        Log.d("MainActivity" , "save button clicked")
                        viewModel.login(emailState.value, passwordState.value)
                    },
                    onContinueSignUpButtonClick = {
                        Log.d("MainActivity" , "save button clicked")
                        viewModel.signUp(emailState.value, usernameState.value, passwordState.value)
                    }
                ).also {
                    Log.d("MainActivity" , viewModel.email.value.toString())
                    Log.d("MainActivity" , viewModel.username.value.toString())
                    Log.d("MainActivity" , viewModel.password.value.toString())
                } //debug
            }
        }
    }

    //TODO make method that lead us to new activity after registration

}


