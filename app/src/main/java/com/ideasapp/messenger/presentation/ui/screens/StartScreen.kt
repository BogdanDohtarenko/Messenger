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
    onEmailChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onContinueButtonClick: () -> Unit,
) {

    val navController = rememberNavController()

    NavHost(navController, startDestination = AppRoute.Screen.Login.route) {

        composable( AppRoute.Screen.Login.route) {
            LoginScreen(
                email = email,
                password = password,
                onEmailChange = onEmailChange,
                onPasswordChange = onPasswordChange,
                onContinueButtonClick = onContinueButtonClick,
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
                onEmailChange = onEmailChange,
                onUsernameChange = onUsernameChange,
                onPasswordChange = onPasswordChange,
                onBackButtonClick = {
                    Log.d("MainActivity", "back button clicked")
                    navController.popBackStack()
                },
                onContinueButtonClick = onContinueButtonClick
            )
        }
    }
}