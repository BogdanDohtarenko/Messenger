package com.ideasapp.messenger.presentation.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ideasapp.messenger.presentation.ui.AppRoute


@Composable
fun StartScreen(
    email: String,
    username: String,
    password: String,
    isErrorInEmail: Boolean,
    isErrorInUsername: Boolean,
    isErrorInPassword: Boolean,
    onEmailChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onContinueLoginButtonClick: () -> Unit,
    onContinueSignUpButtonClick: () -> Unit
) {

    val navController = rememberNavController()

    NavHost(navController, startDestination = AppRoute.Screen.Login.route) {

        composable( AppRoute.Screen.Login.route) {
            LoginScreen(
                email = email,
                password = password,
                isErrorInEmail = isErrorInEmail,
                isErrorInPassword = isErrorInPassword,
                onEmailChange = onEmailChange,
                onPasswordChange = onPasswordChange,
                onContinueButtonClick = onContinueLoginButtonClick,
                onSignUpTextClick = {
                    Log.d("MainActivity", "sign up clicked")
                    navController.navigate(AppRoute.Screen.SignUp.route)
                }
            )
        }

        composable(AppRoute.Screen.SignUp.route) {
            SignUpScreen(
                email = email,
                username = username,
                password = password,
                isErrorInEmail = isErrorInEmail,
                isErrorInUsername = isErrorInUsername,
                isErrorInPassword = isErrorInPassword,
                onEmailChange = onEmailChange,
                onUsernameChange = onUsernameChange,
                onPasswordChange = onPasswordChange,
                onBackButtonClick = {
                    Log.d("MainActivity", "back button clicked")
                    navController.popBackStack()
                },
                onContinueButtonClick = onContinueSignUpButtonClick
            )
        }
    }
}