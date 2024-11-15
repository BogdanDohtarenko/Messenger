package com.ideasapp.messenger.presentation.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.ideasapp.messenger.presentation.ui.screens.StartScreen
import com.ideasapp.messenger.presentation.ui.theme.MessengerTheme
import com.ideasapp.messenger.presentation.viewModel.SignUpLoginViewModel


class StartActivity : ComponentActivity() {

    private lateinit var viewModel: SignUpLoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SignUpLoginViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            //TODO check Sumin plans
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
                        loginWithRedirection(emailState, passwordState)
                    },
                    onContinueSignUpButtonClick = {
                        Log.d("MainActivity" , "save button clicked")
                        signUpWithRedirection(emailState , usernameState , passwordState) //TODO падает с намбер формат ексепшион
                    }
                ).also {
                    Log.d("MainActivity" , viewModel.email.value.toString())
                    Log.d("MainActivity" , viewModel.username.value.toString())
                    Log.d("MainActivity" , viewModel.password.value.toString())
                } //debug
            }
        }
    }

    private fun signUpWithRedirection(
        emailState: State<String>,
        usernameState: State<String>,
        passwordState: State<String>
    ) {
        val isSignUpSuccess =
            viewModel.signUp(emailState.value, usernameState.value, passwordState.value)
        if (isSignUpSuccess) {
            val userId = FirebaseAuth.getInstance().currentUser?.uid ?: MessengerActivity.UNDEFINED_ID
            val intent = MessengerActivity.newIntent(this , userId)
            startActivity(intent)
            finish()
        } else {
            Log.d("SignUp", "sign up isn't success")
        }
    }

    private fun loginWithRedirection(
        emailState: State<String> ,
        passwordState: State<String>
    ) {
        val isSignInSuccess =
            viewModel.login(emailState.value , passwordState.value)
        if (isSignInSuccess) {
            val userId = FirebaseAuth.getInstance().currentUser?.uid ?: MessengerActivity.UNDEFINED_ID
            val intent = MessengerActivity.newIntent(this , userId)
            startActivity(intent)
            finish()
        } else {
            Log.d("SignIn", "sign in isn't success")
        }
    }

    //TODO make method that lead us to new activity after registration

}


