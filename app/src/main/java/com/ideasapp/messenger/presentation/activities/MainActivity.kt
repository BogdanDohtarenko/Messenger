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
                SignUpScreen(
                    emailState.value,
                    onValueChange = { email -> signUpViewModel.onEmailChange(email) }
                ).also { Log.d("MainActivity", signUpViewModel.email.value.toString()) }
            }
        }

    }
}
