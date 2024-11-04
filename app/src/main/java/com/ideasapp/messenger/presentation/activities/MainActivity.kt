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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val signUpLoginViewModel: SignUpLoginViewModel = ViewModelProvider(this)[SignUpLoginViewModel::class.java]

        setContent {
            //TODO watch videos
            MessengerTheme {
                val emailState = signUpLoginViewModel.email.observeAsState("")
                val usernameState = signUpLoginViewModel.username.observeAsState("")
                val passwordState = signUpLoginViewModel.password.observeAsState("")
                val errorEmailState = signUpLoginViewModel.errorEmail.observeAsState(false)
                val errorUsernameState = signUpLoginViewModel.errorUsername.observeAsState(false)
                val errorPasswordState = signUpLoginViewModel.errorPassword.observeAsState(false)
                StartScreen(
                    emailState.value,
                    usernameState.value,
                    passwordState.value,
                    errorEmailState.value,
                    errorUsernameState.value,
                    errorPasswordState.value,
                    onEmailChange = { email ->
                        signUpLoginViewModel.resetEmailError()
                        signUpLoginViewModel.onEmailChange(email)
                    },
                    onUsernameChange = { username ->
                        signUpLoginViewModel.resetUsernameError()
                        signUpLoginViewModel.onUsernameChange(username)
                    },
                    onPasswordChange = { password ->
                        signUpLoginViewModel.resetPasswordError()
                        signUpLoginViewModel.onPasswordChange(password)
                    },
                    onContinueButtonClick = {
                        Log.d("MainActivity" , "save button clicked")
                        signUpLoginViewModel.parseInputData()
                    },
                    //TODO amend onContinue
                ).also {
                    Log.d("MainActivity" , signUpLoginViewModel.email.value.toString())
                    Log.d("MainActivity" , signUpLoginViewModel.username.value.toString())
                    Log.d("MainActivity" , signUpLoginViewModel.password.value.toString())
                } //debug
            }
        }
    }

    //TODO make method that lead us to new activity after registration

}
