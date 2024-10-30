package com.ideasapp.messenger.presentation.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ideasapp.messenger.presentation.ui.screens.SignUpScreen
import com.ideasapp.messenger.presentation.ui.theme.MessengerTheme
import com.ideasapp.messenger.presentation.viewModel.SignUpViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val signUpViewModel: SignUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
        setContent {
            MessengerTheme {
                val emailState = signUpViewModel.email.observeAsState("")
                val usernameState = signUpViewModel.username.observeAsState("")
                val passwordState = signUpViewModel.password.observeAsState("")
                SignUpScreen(
                    emailState.value,
                    usernameState.value,
                    passwordState.value,
                    onEmailChange = { email -> signUpViewModel.onEmailChange(email) },
                    onUsernameChange = { username -> signUpViewModel.onUsernameChange(username) },
                    onPasswordChange = { password -> signUpViewModel.onPasswordChange(password) },
                    onBackButtonClick = {Log.d("MainActivity", "back button clicked")},
                    onContinueButtonClick = {Log.d("MainActivity", "save button clicked")}
                ).also {
                    Log.d("MainActivity", signUpViewModel.email.value.toString())
                    Log.d("MainActivity", signUpViewModel.username.value.toString())
                    Log.d("MainActivity", signUpViewModel.password.value.toString())
                }
            }
        }

    }
}
