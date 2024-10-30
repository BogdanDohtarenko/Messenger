package com.ideasapp.messenger.presentation.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.ideasapp.messenger.presentation.ui.screens.Login
import com.ideasapp.messenger.presentation.ui.screens.SignUpScreen
import com.ideasapp.messenger.presentation.ui.theme.MessengerTheme
import com.ideasapp.messenger.presentation.viewModel.SignUpLoginViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val signUpLoginViewModel: SignUpLoginViewModel = ViewModelProvider(this)[SignUpLoginViewModel::class.java]

        setContent {
            MessengerTheme {
                val emailState = signUpLoginViewModel.email.observeAsState("")
                val usernameState = signUpLoginViewModel.username.observeAsState("")
                val passwordState = signUpLoginViewModel.password.observeAsState("")
//                SignUpScreen(
//                    emailState.value,
//                    usernameState.value,
//                    passwordState.value,
//                    onEmailChange = { email -> signUpLoginViewModel.onEmailChange(email) },
//                    onUsernameChange = { username -> signUpLoginViewModel.onUsernameChange(username) },
//                    onPasswordChange = { password -> signUpLoginViewModel.onPasswordChange(password) },
//                    onBackButtonClick = {Log.d("MainActivity", "back button clicked")},
//                    onContinueButtonClick = {Log.d("MainActivity", "save button clicked")}
//                ).also {
//                    Log.d("MainActivity", signUpLoginViewModel.email.value.toString())
//                    Log.d("MainActivity", signUpLoginViewModel.username.value.toString())
//                    Log.d("MainActivity", signUpLoginViewModel.password.value.toString())
//                }
                Login(
                    emailState.value,
                    passwordState.value,
                    onEmailChange = { email -> signUpLoginViewModel.onEmailChange(email) },
                    onPasswordChange = { password -> signUpLoginViewModel.onPasswordChange(password) },
                    onContinueButtonClick = {Log.d("MainActivity", "save button clicked")}
                ).also {
                    Log.d("MainActivity", signUpLoginViewModel.email.value.toString())
                    Log.d("MainActivity", signUpLoginViewModel.password.value.toString())
                }
            }
        }


    }
}
